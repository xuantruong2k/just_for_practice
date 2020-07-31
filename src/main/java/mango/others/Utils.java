package mango.others;

import java.util.ArrayList;

public class Utils {

    // display integer value in binary character (1 integer = 4 bytes = 32 bits)
    public static String displayInBinary(int value) {
        String str = String.format("%32s", Integer.toBinaryString(value)).replace(' ', '0');
        return str;
    }

    // display long value in binary character (1 long = 8 bytes = 64 bits)
    public static String displayInBinary(long value) {
        String str = String.format("%64s", Long.toBinaryString(value)).replace(' ', '0');
        return str;
    }

    public static String formatInt2Str(int value, int numOfChar) {
        String f = "%" + numOfChar + "s";
        return String.format(f, value);
    }

    public static int leftShift(int value, int bit) {
        return (value << bit);
    }

    public static int rightShift(int value, int bit) {
        return (value >> bit);
    }

    /**
     * Find the index of minimum value in an integer array
     * @param arr the integer array
     * @return the index of minimum value
     */
    public static int findMin(int[] arr) {
        int idx = -1;
        if (arr.length > 0)
            idx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[idx]) {
                idx = i;
            }
        }

        return idx;
    }

    public static int findMin(ArrayList<Integer> arr) {
        int idx = -1;
        if (arr.size() > 0)
            idx = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(idx)) {
                idx = i;
            }
        }

        return idx;
    }

    /**
     * Find the index of maximum value in an integer array
     * @param arr the integer array
     * @return the index of maximum value
     */
    public static int findMax(int[] arr) {
        int idx = -1;
        if (arr.length > 0)
            idx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[idx]) {
                idx = i;
            }
        }

        return idx;
    }

    public static int findMax(ArrayList<Integer> arr) {
        int idx = -1;
        if (arr.size() > 0)
            idx = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > arr.get(idx)) {
                idx = i;
            }
        }

        return idx;
    }
}
