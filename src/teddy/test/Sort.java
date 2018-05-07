package teddy.test;

public class Sort {

	// complexity: O(n2)
	// (n-1) + (n-2) + (n-3) + ... + 1 = n * (n-1) / 2
	public static int[] sortSelection(int[] input) {
		int length = input.length;
		
		for (int i = 0; i < length - 1; i++) {
			int min = i;			
			for (int j = i + 1; j < length; j++) { // from (i + 1) to end of array, find the index which has lowest value
				if (input[j] < input[min]) {
					min = j;
				}
			}
			
			if (min != i) { // swap the value at index 'i' and 'min'
				int tmp = input[i];
				input[i] = input[min];
				input[min] = tmp;
			}
		}
		
		return input;
	}
	
	// complexity: O(n2)
	// (n-1) + (n-2) + (n-3) + ... + 1 = n * (n-1) / 2
	public static int[] sortBubble(int [] input) {
		
		int length = input.length;
		
		for (int i = length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (input[j] > input[j + 1]) {
					int tmp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = tmp;
				}
			}				
		}
		
//		for (int i = 0; i < length - 1; i++) {
//			for (int j = length - 1; j > i; j--) {
//				if (input[j] < input[j - 1]) {
//					int tmp = input[j];
//					input[j] = input[j - 1];
//					input[j - 1] = tmp;
//				}
//			}
//		}
		
		return input;
	}
	
//	public static int[] sortQuick(int[] input) {
//		
//		
//		return input;
//	}
//	
//	private static int[]
}
