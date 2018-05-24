package teddy.hackerrank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class HackerRank {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// int n = scanner.nextInt();
		// for (int i = 0; i < n; i++) {
		// String s = scanner.nextLine();
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		//
		// String evenStr = "";
		// String oddStr = "";
		// for (int j = 0; j < s.length(); j+=2) {
		// evenStr += s.charAt(j);
		// }
		// for (int j = 1; j < s.length(); j+=2) {
		// oddStr += s.charAt(j);
		// }
		// System.out.println(evenStr + " " + oddStr);
		// }
		String s = "welcometojava";
		int k = 3;
		String str = getSmallestAndLargest(s, k);
		System.out.println(str);
	}

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        List<String> sub = new ArrayList<String>();
        for (int i = 0; i <= s.length() - k; i++) {
            sub.add(s.substring(i, i+k));
        }
        if (sub.size() > 0) {
            smallest = sub.get(0);
            largest = sub.get(0);
        }
        for (int i = 1; i < sub.size(); i++) {
        	if (compareString(smallest, sub.get(i)) == 1) // smallest > sub.get(i)
        		smallest = sub.get(i);
        	if (compareString(largest, sub.get(i)) == -1) // largest < sub.get(i)
        		largest = sub.get(i);
        }
        
        return smallest + "\n" + largest;
    }
    
    public static int compareString(String s1, String s2) {
    	int result = 0; // equal
    	
    	int len1 = s1.length();
    	int len2 = s2.length();
    	for (int i = 0; i < len1 && i < len2; i++) {
    		if (s1.charAt(i) < s2.charAt(i)) {
    			result = -1; // s1 < s2 in Lexicographical Order
    			break;
    		} else if (s1.charAt(i) > s2.charAt(i)) {
    			result = 1; // s1 > s2 in Lexicographical Order
    			break;
    		}    			
    	}
    	
    	// if goes here, means all characters in s1 and s2 are the same
    	// so check the length of s1 & s2
    	if (len1 < len2) 
    		result = -1;
    	else if (len1 > len2)
    		result = 1;
    	
    	return result;
    }
}
