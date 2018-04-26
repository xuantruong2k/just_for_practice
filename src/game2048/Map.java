package game2048;

import java.util.ArrayList;
import java.util.Random;

import teddy.test.Utils;

public class Map {

	private int width;
	private int height;
	private int[] data;
	
	private static Map sharedInstance = null;
	
	public static Map getInstance() {
		if (sharedInstance == null) {
			sharedInstance = new Map(4, 4); // set default width and height of map
		}
		
		return sharedInstance;
	}
	
	public static Map create(int w, int h) {
		if (sharedInstance == null) {
			sharedInstance = new Map(w, h);
		} else if (sharedInstance.getWidth() != w || sharedInstance.getHeight() != h) {
			sharedInstance = new Map(w, h);
		}
		
		return sharedInstance;
	}

	private Map(int w, int h) {
		width = w;
		height = h;

		initMap();

		generateMap();
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}

	private void initMap() {
		int len = width * height;
		data = new int[len];

		for (int i = 0; i < len; i++) {
			data[i] = GameConst.NUMBER_NONE;
		}
	}

	public void printMap() {
		System.out.print("\n");
		int idx;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				idx = getIndex(x, y);
				System.out.print(" " + Utils.formatInt2Str(data[idx], 2));
			}
			System.out.print("\n");
		}
	}

	private int getIndex(int xPos, int yPos) {
		return (yPos * width + xPos);
	}

	public void generateMap() {
		data[0] = GameConst.NUMBER_2;
		data[1] = GameConst.NUMBER_2;
		data[2] = GameConst.NUMBER_4;
		data[3] = GameConst.NUMBER_4;

		data[4] = GameConst.NUMBER_2;
		data[5] = GameConst.NUMBER_4;
		data[6] = GameConst.NUMBER_NONE;
		data[7] = GameConst.NUMBER_2;

		data[8] = GameConst.NUMBER_NONE;
		data[9] = GameConst.NUMBER_2;
		data[10] = GameConst.NUMBER_2;
		data[11] = GameConst.NUMBER_4;

		data[12] = GameConst.NUMBER_2;
		data[13] = GameConst.NUMBER_NONE;
		data[14] = GameConst.NUMBER_2;
		data[15] = GameConst.NUMBER_4;
	}

	public int[] generateRandomPosForNextNumber(ArrayList<Integer> availablePos) {
		int len = availablePos.size();
		int maxNumber = len > 2 ? 2 : 1;
		int[] result = new int[maxNumber];

		Random rand = new Random();

		// assign the first position
		int pos = rand.nextInt(len);
		result[0] = availablePos.get(pos).intValue();

		for (int i = 1; i < maxNumber; i++) {
			do {
				pos = rand.nextInt(len);
				result[i] = availablePos.get(pos).intValue();
			} while (result[i - 1] == result[i]);
		}
		
		return result;
	}
	
	public ArrayList<Integer> findAvailablePos() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < data.length; i++) {
			if (data[i] == GameConst.NUMBER_NONE)
				result.add((Integer)i);
		}
		
		return result;
	}

	// make sure this function is called after passing the conditions in canMerge
	public void merge(int pos1, int pos2) {
		data[pos1] = nextNumber(data[pos1]); // set the next number to idx1
		data[pos2] = GameConst.NUMBER_NONE; // set the 'None'
	}

	public boolean canMerge(int pos1, int pos2) {
		int num1 = data[pos1];
		int num2 = data[pos2];
		return (num1 == num2 && !isEmpty(pos1) && !isLast(pos1));
	}

	public boolean isEmpty(int pos) {
		return (data[pos] == GameConst.NUMBER_NONE);
	}

	public boolean isLast(int pos) {
		return (data[pos] == GameConst.NUMBER_2048);
	}

	public int nextNumber(int number) {
		if (number == GameConst.NUMBER_2)
			return GameConst.NUMBER_4;
		if (number == GameConst.NUMBER_4)
			return GameConst.NUMBER_8;
		if (number == GameConst.NUMBER_8)
			return GameConst.NUMBER_16;
		if (number == GameConst.NUMBER_16)
			return GameConst.NUMBER_32;
		if (number == GameConst.NUMBER_32)
			return GameConst.NUMBER_64;
		if (number == GameConst.NUMBER_128)
			return GameConst.NUMBER_256;
		if (number == GameConst.NUMBER_256)
			return GameConst.NUMBER_512;
		if (number == GameConst.NUMBER_512)
			return GameConst.NUMBER_1024;
		if (number == GameConst.NUMBER_1024)
			return GameConst.NUMBER_2048;

		return GameConst.NUMBER_NONE;
	}

	public boolean update() {
		ArrayList<Integer> availablePos = findAvailablePos();
		if (availablePos.size() <= 0) {
			return false; // end game
		} else {
			// generate the random '2' to the map
			int[] randomPos = generateRandomPosForNextNumber(availablePos);			
			for (int i = 0; i < randomPos.length; i++) {
				data[randomPos[i]] = GameConst.NUMBER_2;
			}
			
			// then wait for user 's move
			return true; // game is not end
		}
	}
	
	public void updateMap(int dir) {
		if (dir == GameConst.DIRECTION_LEFT)
			moveLeft();
		else if (dir == GameConst.DIRECTION_RIGHT)
			moveRight();
		else if (dir == GameConst.DIRECTION_UP)
			moveUp();
		else if (dir == GameConst.DIRECTION_DOWN)
			moveDown();
	}

	private void moveLeft() {

		for (int i = 0; i < height; i++) {

			// check and merge value on each cell
			for (int j = 0; j < width - 1; j++) {
				int currIdx = getIndex(j, i);
				if (isEmpty(currIdx))
					continue;

				for (int k = j + 1; k < width; k++) {
					int nextIdx = getIndex(k, i);
					if (!isEmpty(nextIdx)) {
						if (canMerge(currIdx, nextIdx)) {
							merge(currIdx, nextIdx);
						}
						break;
					}
				}
			}

			// move all the non-empty cell to left
			for (int j = 0; j < width - 1; j++) {
				int currIdx = getIndex(j, i);
				if (isEmpty(currIdx)) {
					for (int k = j + 1; k < width; k++) {
						int nextIdx = getIndex(k, i);
						if (!isEmpty(nextIdx)) {
							data[currIdx] = data[nextIdx];
							data[nextIdx] = GameConst.NUMBER_NONE;
							break; // break the 'k' loop
						}
					}
				}
			}
		}
	}

	private void moveRight() {
		for (int i = 0; i < height; i++) {

			// check and merge value on each cell
			for (int j = width - 1; j > 0; j--) {
				int currIdx = getIndex(j, i);
				if (isEmpty(currIdx))
					continue;

				for (int k = j - 1; k >= 0; k--) {
					int nextIdx = getIndex(k, i);
					if (!isEmpty(nextIdx)) {
						if (canMerge(currIdx, nextIdx)) {
							merge(currIdx, nextIdx);
						}
						break;
					}
				}
			}

			// move all the non-empty cell to right
			for (int j = width - 1; j > 0; j--) {
				int currIdx = getIndex(j, i);
				if (isEmpty(currIdx)) {
					for (int k = j - 1; k >= 0; k--) {
						int nextIdx = getIndex(k, i);
						if (!isEmpty(nextIdx)) {
							data[currIdx] = data[nextIdx];
							data[nextIdx] = GameConst.NUMBER_NONE;
							break; // break the 'k' loop
						}
					}
				}
			}
		}
	}

	private void moveUp() {
		for (int i = 0; i < width; i++) {

			// check and merge value on each cell
			for (int j = 0; j < height - 1; j++) {
				int currIdx = getIndex(i, j);
				if (isEmpty(currIdx))
					continue;

				for (int k = j + 1; k < height; k++) {
					int nextIdx = getIndex(i, k);
					if (!isEmpty(nextIdx)) {
						if (canMerge(currIdx, nextIdx)) {
							merge(currIdx, nextIdx);
						}
						break;
					}
				}
			}

			// move all the non-empty cell to up
			for (int j = 0; j < height - 1; j++) {
				// int currIdx = getIndex(j, i);
				int currIdx = getIndex(i, j);
				if (isEmpty(currIdx)) {
					for (int k = j + 1; k < height; k++) {
						// int nextIdx = getIndex(k, i);
						int nextIdx = getIndex(i, k);
						if (!isEmpty(nextIdx)) {
							data[currIdx] = data[nextIdx];
							data[nextIdx] = GameConst.NUMBER_NONE;
							break; // break the 'k' loop
						}
					}
				}
			}
		}
	}

	private void moveDown() {
		for (int i = 0; i < width; i++) {
			// check and merge value on each cell
			for (int j = height - 1; j > 0; j--) {
				int currIdx = getIndex(i, j);
				if (isEmpty(currIdx))
					continue;

				for (int k = j - 1; k >= 0; k--) {
					int nextIdx = getIndex(i, k);
					if (!isEmpty(nextIdx)) {
						if (canMerge(currIdx, nextIdx)) {
							merge(currIdx, nextIdx);
						}
						break;
					}
				}
			}

			// move all the non-empty cell to down
			for (int j = height - 1; j > 0; j--) {
				int currIdx = getIndex(i, j);
				if (isEmpty(currIdx)) {
					for (int k = j - 1; k >= 0; k--) {
						// int nextIdx = getIndex(k, i);
						int nextIdx = getIndex(i, k);
						if (!isEmpty(nextIdx)) {
							data[currIdx] = data[nextIdx];
							data[nextIdx] = GameConst.NUMBER_NONE;
							break; // break the 'k' loop
						}
					}
				}
			}
		}
	}
}
