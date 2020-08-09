package mango.hackerrank;

import java.util.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import mango.hackerrank.linkedlist.DoublyLinkedListNode;
import mango.hackerrank.linkedlist.SinglyLinkedListNode;

public class HackerRank {

//    private static final Logger logger = LogManager.getLogger(HackerRank.class);
    private static final Logger logger = LogManager.getLogger();
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

        // String s = "welcometojava";
        // int k = 3;
        // String str = getSmallestAndLargest(s, k);
        // System.out.println(str);

        // int[] arr = { 5, 4, 4, 2, 2, 8 };
        // int[] ret = cutTheSticks(arr);
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        List<String> sub = new ArrayList<String>();
        for (int i = 0; i <= s.length() - k; i++) {
            sub.add(s.substring(i, i + k));
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
            for (int j = 0; j < arr[i].length - 2; j++) {
                int sum = 0;
                // first line
                sum += arr[i][j];
                sum += arr[i][j + 1];
                sum += arr[i][j + 2];
                // second line
                sum += arr[i + 1][j + 1];
                // third line
                sum += arr[i + 2][j];
                sum += arr[i + 2][j + 1];
                sum += arr[i + 2][j + 2];

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
//    2.1 two examples at hacker rank
//
//    -----
//    3. Data structure
//
//    **Solution 1:**
//
//    + using an array to store the output
//    + for each query, iterate through the strings array to find out how many occurrences
//
//    -> Complexity: O(n*m)
//
//    Quiz: is there any better solution?
//    Using a map <key, value>?
//
//    **Solution 2:**
//    + convert strings array -> map
//    + iterate through the queries, for each query, how many occurrences in the map?
//
//    -> Complexity: O(1)
//
//    -----
//    4. Algorithm
//    HashMap<String, Integer> map = new HashMap<String, Integer>();
//
//    -----
//    5. Code with intent

    /**
     *
     * https://www.hackerrank.com/challenges/sparse-arrays/problem
     *
     * @param strings
     * @param queries
     * @return
     */
    public static int[] matchingStrings(String[] strings, String[] queries) {
        int[] results = new int[queries.length];

        // generate hash map
        HashMap<String, Integer> strHashMap = new HashMap<String, Integer>();
        for (int i = 0; i < strings.length; i++) {
            String key = strings[i];
            if (strHashMap.containsKey(key)) {
                strHashMap.put(key, strHashMap.get(key) + 1);
            } else { // not exist in hash map
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

    /**
     * https://www.hackerrank.com/challenges/compare-two-linked-lists/problem
     *
     * @param head1
     * @param head2
     * @return true both linked lists are same, otherwise return false
     */
    public static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        while (head1 != null) {
            if (head2 == null) // head1 is longer than head2
                return false;

            if (head1.data != head2.data) // difference in data
                return false;

            head1 = head1.next;
            head2 = head2.next;
        }
        if (head2 != null) // head1 is shorter than head2
            return false;

        return true; // equal

    }

    /**
     * https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/
     *
     * @param head
     * @param positionFromTail
     * @return
     */
    public static int getNodeFromTail(SinglyLinkedListNode head, int positionFromTail) {

        // solution 1: using an array
//        ArrayList<Integer> valueArr = new ArrayList<Integer>();
//
//        while (head != null) {
//            valueArr.add(head.data);
//            head = head.next;
//        }
//
//        return valueArr.get(valueArr.size() - positionFromTail - 1);

        // solution 2: using 2 node
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode fromTail = head;
        int idx = 0;

        while (current != null) {
            current = current.next;
            if (idx++ > positionFromTail) {
                fromTail = fromTail.next;
            }
        }

        return fromTail.data;
    }

    /**
     * https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem
     *
     * @param head
     * @return
     */
    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode next;

        while (current != null) {

            next = current.next;
            if (next != null && next.data == current.data) {
                // delete the next node, which is has duplicate data
                current.next = next.next;
                next.next = null;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    /**
     * https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem?h_r=next-challenge&h_v=legacy
     *
     * @param headA
     * @param headB
     * @return
     */
    public static SinglyLinkedListNode mergeLists(SinglyLinkedListNode headA, SinglyLinkedListNode headB) {
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

    /**
     * https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem
     *
     * @param head
     * @return
     */
    public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if (head == null)
            return null;

        DoublyLinkedListNode nextNode = null;
        DoublyLinkedListNode prevNode = null;
        DoublyLinkedListNode currNode = head;

        while (currNode != null) {
            nextNode = currNode.next;
            // swap the next and prev of the current node
            currNode.next = prevNode;
            currNode.prev = nextNode;

            prevNode = currNode;
            currNode = nextNode;
        }

        head = prevNode;
        return head;
    }

    /**
     * https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem
     *
     * @param head
     * @param data
     * @return
     */
    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode inserted = new DoublyLinkedListNode(data);

        DoublyLinkedListNode currNode = head;
        if (currNode == null)
            return inserted;

        // insert at head
        if (currNode.data > data) {
            inserted.next = currNode;
            currNode.prev = inserted;
            return inserted;
        }

        while (currNode != null) {
            DoublyLinkedListNode nextNode = currNode.next;

            if (nextNode == null) { // insert at tail
                currNode.next = inserted;
                inserted.prev = currNode;
                break;
            } else if (nextNode.data > data) { // insert at middle (between current node and next node)
                inserted.next = nextNode;
                inserted.prev = currNode;
                nextNode.prev = inserted;
                currNode.next = inserted;
                break;
            }

            currNode = nextNode;
        }

        return head;

    }

    /**
     * https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
     *
     * @param head
     * @return true: has Cycle, otherwise return false
     */
    public static boolean hasCycle(SinglyLinkedListNode head) {

        // solution 1: using 2 runners
        // the fast will run double as the low
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;

        // solution 2: using a hash map

//        if (head == null) // the list is empty, so no cycle
//            return false;
//
//        HashMap<SinglyLinkedListNode, Integer> occurrence = new HashMap<SinglyLinkedListNode, Integer>();
//        SinglyLinkedListNode current = head;
//
//        while (current != null) {
//
//            if (occurrence.get(current) == null) { // the current node is not occurred on the list
//                occurrence.put(current, 1);
//            } else { // the current node has occurred in the list before, so cycle
//                return true;
//            }
//
//            current = current.next;
//        }
//
//        return false;
    }

    /**
     * Find merge point of 2 joined linked list
     * https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem
     *
     * @param headA
     * @param headB
     * @return
     */
    public static int findMergeNode(SinglyLinkedListNode headA, SinglyLinkedListNode headB) {

        // solution 1: using hash map
        // there will 2 loops
        HashMap<SinglyLinkedListNode, Integer> mapA = new HashMap<SinglyLinkedListNode, Integer>();

        SinglyLinkedListNode current = headA;
        while (current != null) {
            mapA.put(current, 1);
            current = current.next;
        }

        current = headB;
        while (current != null) {
            if (mapA.get(current) != null) {
                return current.data;
            }
            current = current.next;
        }

        return -1; // there is no merge point
    }


    /**
     * Examples:
     *   inputs = [5, 8, 3, 2, 0, 7, 9, -1, 13]
     *   reference = 8
     *   --> pair == 8 => [5, 3], [8, 0], [9, -1]
     *   --> result = 3 pairs
     * @param inputs
     * @param reference
     * @return
     */
    public static int countPairEqualToInt(int[] inputs, int reference) {
        int count = 0;

        // solution 1: brute force
        // complexity = O(n2)
//        for (int i = 0; i < inputs.length-1; i++) {
//            for (int j = i + 1; j < inputs.length; j++) {
//                if (inputs[i] + inputs[j] == reference)
//                    count++;
//            }
//        }

        // solution 2: using a map
        // complexity = 0(n)
        // require more space in memory
        Map<Integer, Integer> appearance = new HashMap<>();
        for (int i = 0; i < inputs.length; i++) {
            int missing = reference - inputs[i];
            if (appearance.containsKey(missing)) {
                count++;
            } else {
                appearance.put(inputs[i], 1);
            }
        }

        // solution 3:
//        for (int i = 0; i < inputs.length; i++) {
//
//        }

        return count;
    }


    // Complete the hackerrankInString function below.
    public static String hackerrankInString(String s) {
        String hackerRank = "hackerrank";
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == hackerRank.charAt(idx)) {
                if (idx == hackerRank.length() - 1)
                    return "YES";
                idx++;
            }
        }

        return "NO";
    }

    /**
     * https://www.hackerrank.com/challenges/two-arrays/problem
     * @param k
     * @param A
     * @param B
     * @return
     */
    public static String compareTwoArrays(int k, int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0, j = A.length - 1; i < A.length; i++, j--) {
            if (A[i] + B[j] < k)
                return "NO";
        }
        return "YES";
    }

    /**
     * https://www.hackerrank.com/challenges/sherlock-and-array/problem
     * @param arr
     * @return
     */
    public static int balancedSum(int[] arr) {
        int sum = 0;
        Map<Integer, Integer> leftSum = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            leftSum.put(i, sum);
            sum += arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int rightSum = sum - arr[i] - leftSum.get(i);
            if (rightSum == leftSum.get(i))
                return i;
        }
        return -1;
    }

    /**
     * https://www.hackerrank.com/challenges/equality-in-a-array/problem
     * @param arr
     * @return
     */
    public static int equalizeArray(int[] arr) {
        Map<Integer, Integer> equalMap = new HashMap<>();

        // using map to store the equal count of each number
        for (int i = 0; i < arr.length; i++) {
            if (equalMap.containsKey(arr[i])) {
                equalMap.put(arr[i], equalMap.get(arr[i]) + 1);
            } else {
                equalMap.put(arr[i], 1);
            }
        }

        // find the max of equal count
        int max = Integer.MIN_VALUE;
        Iterator<Map.Entry<Integer, Integer>> iterator = equalMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (max < entry.getValue())
                max = entry.getValue();
        }

        return arr.length - max;
    }

    /**
     * count the sub array of an array which the sum of triplet elements in sub array is less than integer k
     * https://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/
     * @param sum
     * @param arr
     * @return
     */
    private int countTriplet(int sum, int[] arr) {
        int count = 0;
        Arrays.sort(arr);

        int len = arr.length;
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] >= sum) {
                    k--;
                } else {
                    count += (k - j);
                    j++;
                }
            }
        }

        return count;
    }

    /**
     *
     * @param arr
     * @return
     */
    public static int arrayToMaxNumber(List<String> arr) {
//        Collections.sort(arr, new Comparator<String>() {
//            @Override
//            public int compare(String arg0, String arg1) {
//                Integer a = Integer.parseInt(arg0 + arg1);
//                Integer b = Integer.parseInt(arg1 + arg0);
//                if (a < b) {
//                    return -1;
//                } else if (a > b) {
//                    return 1;
//                }
//                return 0;
//            }
//        });

        Collections.sort(arr, (arg0, arg1) -> {
            Integer a = Integer.parseInt(arg0 + arg1);
            Integer b = Integer.parseInt(arg1 + arg0);
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
            return 0;
        });

        String result = "";
        for (int i = arr.size() - 1; i >= 0; i--) {
//        for (int i = 0; i < arr.size(); i++) {
            result += arr.get(i);
        }

        if (result.equals(""))
            return -1;

        return Integer.parseInt(result);
    }

    // Complete the superReducedString function below.
    public static String superReducedString(String s) {

        int index = 0;
        int len = s.length();
        while (index < len - 1) {
            if (s.charAt(index) == s.charAt(index + 1)) {
                if (index + 2 < len)
                    s = s.substring(0, index) + s.substring(index + 2);
                else
                    s = s.substring(0, index);
                len = s.length();
                index = (index - 1 < 0) ? 0 : index - 1;
            } else {
                index++;
            }
        }

        if (s.length() == 0)
            return "Empty String";

        return s;
    }

}
