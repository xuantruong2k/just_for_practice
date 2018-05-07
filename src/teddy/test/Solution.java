package teddy.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	/*
	 * This method sort the integer base on the quantity of '1' in it's binary string format
	 * This is 50th question at CrossOver 
	 */
	public static int[] rearrangeIntegerBaseOnBinaryFormat(int[] elements) {

		int length = elements.length;		
		List<String> binaryList = new ArrayList();
		
		// first convert array of integer in decimal to array of integer in binary string
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
}
