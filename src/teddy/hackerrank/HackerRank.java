package teddy.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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

//		String s = "welcometojava";
//		int k = 3;
//		String str = getSmallestAndLargest(s, k);
//		System.out.println(str);

		int[] arr = {5, 4, 4, 2, 2, 8};
		int[] ret = cutTheSticks(arr);
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

    // https://www.hackerrank.com/challenges/2d-array/problem
    // 2D array - find the maximum 'hourglass' sum
    public static int findMaxiumHourglass(int[][] arr) {
    	int maxSum = Integer.MIN_VALUE;
    	for (int i = 0; i < arr.length - 2; i++) {
    		for (int j = 0; j < arr[i].length - 2; j++ ) {
    			int sum = 0;
    			// first line
    			sum += arr[i][j];
    			sum += arr[i][j+1];
    			sum += arr[i][j+2];
    			// second line
    			sum += arr[i+1][j+1];
    			// third line
    			sum += arr[i+2][j];
    			sum += arr[i+2][j+1];
    			sum += arr[i+2][j+2];

    			if (sum > maxSum) {
    				maxSum = sum;
    			}
    		}
    	}
    	return maxSum;
    }

	// https://www.hackerrank.com/challenges/between-two-sets/problem
	// Between 2 Set
	public static int getTotalX(int[] a, int[] b) {
		int ret = 0;

		int min = a[a.length - 1];
		int max = b[b.length - 1];

		// loop for every element in [min, max] with the increase step min
		for (int val = min; val <= max; val += min) {
			boolean pass = true;

			// all elements of the first array are all factors of 'val'?
			for (int j = 0; j < a.length && pass; j++) {
				if (val % a[j] != 0) {
					pass = false;
					break;
				}
			}

			// 'val' is a factor of all elements of t he second array?
			for (int j = 0; j < b.length && pass; j++) {
				if (b[j] % val != 0) {
					pass = false;
				}
			}

			// if pass is true mean 'val' is the factor
			if (pass)
				ret++;
		}

		return ret;
	}

    // https://www.hackerrank.com/challenges/cut-the-sticks/problem
    public static int[] cutTheSticks(int[] arr) {
    	ArrayList<Integer> tmpRet = new ArrayList<Integer>();
    	// find the minimum value
    	int count = 0;
    	do {
    		count = 0;
	    	int minVal = 0;
	    	for (int i = 0; i < arr.length; i++) {
	    		if (arr[i] > 0 && (minVal == 0 || minVal > arr[i])) {
	    			minVal = arr[i];
	    		}
	    	}

	    	if (minVal > 0) {
		    	for (int i = 0; i < arr.length; i++) {
		    		if (arr[i] != 0) {
		    			count++;
		    			arr[i] -= minVal;
		    		}
		    	}
		    	tmpRet.add(count);
	    	}
    	} while (count > 0);

    	// convert array list to primitive int array
    	int[] ret = new int[tmpRet.size()];
    	for (int i = 0; i < tmpRet.size(); i++) {
    		ret[i] = tmpRet.get(i);
    	}
    	return ret;
    }

//    1. Progress the Problem
//
//    **Input**
//
//    + an array of strings to search
//    + queries : an array of query strings
//
//    **Output**
//
//    + an integer array occurs for each queries
//
//    **explicit**:
//
//    + each string has 1 ~ 20 characters
//    + string must be equal, not include -> string must have the same length
//
//    -----
//    2. Examples / Test Case
//
//    2.1 two examples at hackerrank
//
//    -----
//    3. Data structure
//
//    **Solution 1:**
//
//    + using an array to store the output
//    + for each query, iterate through the strings array to find out how many occurance
//
//    -> Complexibiity: O(n*m)
//
//    Quiz: is there any better solution?
//    Using a map <key, value>?
//
//    **Solution 2:**
//    + convert strings array -> map
//    + iterate through the queries, for each query, how many occurance in the map?
//
//    -> Complexibiity: O(1)
//
//    -----
//    4. Algorithm
//    HashMap<String, Integer> map = new HashMap<String, Integer>();
//
//    -----
//    5. Code with intent

	// https://www.hackerrank.com/challenges/sparse-arrays/problem
	static int[] matchingStrings(String[] strings, String[] queries) {
		int[] results = new int[queries.length];

		// generate hash map
		HashMap<String, Integer> strHashMap = new HashMap<String, Integer>();
		for (int i = 0; i < strings.length; i++) {
			String key = strings[i];
			if (strHashMap.containsKey(key)) {
				strHashMap.put(key, strHashMap.get(key) + 1);
			} else { // not exist in hashmap
				strHashMap.put(key, 1);
			}
		}

		// iterate through queries
		for (int i = 0; i < queries.length; i++) {
			String key = queries[i];
			Integer value = strHashMap.get(key);
			if (value == null)
				results[i] = 0;
			else
				results[i] = value.intValue();
		}

		return results;

  }

  class SinglyLinkedListNode {
    SinglyLinkedListNode next;
    int data;
  }

  static SinglyLinkedListNode mergeLists(SinglyLinkedListNode headA, SinglyLinkedListNode headB) {
    if (headA == null)
      return headB;

    if (headB == null)
      return headA;

    // ensure the head 1 is starts with smaller number than head 2
    if (headA.data > headB.data) {
      SinglyLinkedListNode tmp = headB;
      headB = headA;
      headA = tmp;
    }

    SinglyLinkedListNode listHead = headA;

    while (headB != null) {
      // iterate through nodes in list A until the next node
      // has data bigger than data at the current node in list B
      while (headA.next != null && headB.data > headA.next.data) {
        headA = headA.next;
      }

      // insert current node in list 2 into list 1
      SinglyLinkedListNode nextB = headB.next;
      headB.next = headA.next;
      headA.next = headB;
      headB = nextB;
    }


    return listHead;

  }
}
