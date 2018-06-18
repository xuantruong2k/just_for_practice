package teddy.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	private static Solution instance = null;

	// skeleton pattern
	public static Solution getInstance() {
		if (instance == null) {
			instance = new Solution();
		}
		return instance;
	}

	/*
	 * This method sort the integer base on the quantity of '1' in it's binary
	 * string format This is 50th question at CrossOver
	 */
	public int[] rearrangeIntegerBaseOnBinaryFormat(int[] elements) {

		int length = elements.length;
		List<String> binaryList = new ArrayList();

		// first convert array of integer in decimal to array of integer in binary
		// string
		for (int i = 0; i < length; i++) {
			binaryList.add(Integer.toBinaryString(elements[i]));
		}

		// then override the compare function to sort
		Collections.sort(binaryList, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				// count the number of '1' in both strings
				Pattern pa = Pattern.compile("1");
				Matcher ma = pa.matcher(arg0);
				int count0 = 0;
				while (ma.find()) {
					count0++;
				}

				ma = pa.matcher(arg1);
				int count1 = 0;
				while (ma.find()) {
					count1++;
				}

				// compare the character '1'
				if (count0 < count1) { // less character '1'
					return -1;
				} else if (count0 > count1) { // more character '1'
					return 1;
				} else { // same character '1' so compare the original integer value
					int i0 = Integer.parseInt(arg0, 2);
					int i1 = Integer.parseInt(arg1, 2);
					if (i0 < i1)
						return -1;
					else if (i0 > i1)
						return 1;
				}

				return 0;
			}
		});

		// lastly, convert back the sorted list of binary string to integer value
		int[] output = new int[length];
		for (int i = 0; i < length; i++) {
			output[i] = Integer.parseInt(binaryList.get(i), 2);
		}

		return output;
	}

	public int searchIndexInSortedArray(int[] array, int number) {
		int result = -1;

		int start = 0;
		int end = array.length - 1;
		int mid;

		// using binary search
		while (start <= end) {
			mid = (start + end) / 2;
			if (number < array[mid]) { // on the left
				end = mid - 1;
			} else if (number > array[mid]) { // on the right
				start = mid + 1;
			} else { // number = array[mid]
				result = mid;
				break;
			}
		}

		return result;
	}

	public int searchLastIndexInDuplicateSortedArray(int[] array, int number) {
		int start = 0;
		int end = array.length - 1;
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;
			if (number < array[mid]) { // on the left
				end = mid - 1;
			} else if (number > array[mid]) { // on the right
				start = mid + 1;
			} else { // number == array[mid]
				if (mid + 1 <= end && array[mid + 1] == number) { // not the last index, still on the right
					start = mid + 1;
				} else {
					return mid;
				}
			}
		}

		return -1;
	}

	public int searchFirstIndexInDuplicateSortedArray(int[] array, int number) {
		int start = 0;
		int end = array.length - 1;
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;
			if (number < array[mid]) { // on the left
				end = mid - 1;
			} else if (number > array[mid]) { // on the right
				start = mid + 1;
			} else { // number == array[mid]
				if (mid - 1 >= start && array[mid + 1] == number) { // not the first index, still on the left
					end = mid - 1;
				} else {
					return mid;
				}
			}
		}

		return -1;
	}

	public void runSearchIndexInSortedArray() {
	// 					0, 1, 2, 3, 4,  5,  6,  7,  8
		int[] array = { 1, 1, 1, 7, 9, 13, 13, 13, 13 };
		System.out.println("Index = " + searchLastIndexInDuplicateSortedArray(array, 13));
		System.out.println("Index = " + searchFirstIndexInDuplicateSortedArray(array, 1));
	}

	public void permute(String str) {
		permute("", str);
	}
	
	private void permute(String prefix, String remain) {
		if (remain.length() <= 1) {
			System.out.println("" + (prefix + remain));
		} else {
			for (int i = 0; i < remain.length(); i++) {
				permute(prefix + remain.charAt(i), remain.substring(0, i) + remain.substring(i+1));
			}
		}
	}
}
