import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import mango.hackerrank.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class HackerRankTest {

    @Test
    public void testMatchingString() {

        String[] strings = new String[]{"def", "de", "fgh"};
        String[] queries = new String[]{"de", "lmn", "fgh"};
        int[] expect = new int[] {1, 0, 1};
        int[] result = HackerRank.matchingStrings(strings, queries);
        assertArrayEquals(result, expect);
    }

    @Test
    public void testCountPairEqualToInt() {
        int[] inputs = new int[] {5, 8, 3, 2, 0, 7, 9, -1, 13};
        int reference = 8;
        int expect = 3;
        int count = HackerRank.countPairEqualToInt(inputs, reference);
        assertEquals(expect, count);
    }

    @Test
    public void testHackerrankInString() {
        String input = "rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt";
        String expect = "NO";
        String result = HackerRank.hackerrankInString(input);
        assertEquals(expect, result);
    }

    @Test
    public void testCompareTwoArrays() {
//        int k = 10;
//        int[] A = {2, 1, 3};
//        int[] B = {7, 8, 9};

        int k = 5;
        int[] A = {1, 2, 2, 1};
        int[] B = {3, 3, 3, 4};


        String expect = "NO";
        String result = HackerRank.compareTwoArrays(k, A, B);
        assertEquals(expect, result);
    }

    @Test
    public void testBalancedSum() {
        int[] arr = {2, 0, 0, 0};

        int expect = 0;
        int result = HackerRank.balancedSum(arr);
        assertEquals(expect, result);
    }

//    @Test
//    public void testArrayToMaxNumber() {
//        List<String> arr = new ArrayList<>();
//        arr.add("3");
//        arr.add("9");
//        arr.add("30");
//        arr.add("33");
//
//        int expect = 933330;
//        int result = HackerRank.arrayToMaxNumber(arr);
//        assertEquals(expect, result);
//    }

    @Test
    public void testSuperReducedString() {
        String s = "baab";
        String expect = "Empty String";
        String result = HackerRank.superReducedString(s);
        assertEquals(expect, result);
    }

    @Test
    public void testIsSmartNumber() {
        assertEquals(true, HackerRank.isSmartNumber(1));
        assertEquals(false, HackerRank.isSmartNumber(2));
        assertEquals(false, HackerRank.isSmartNumber(7));
        assertEquals(true, HackerRank.isSmartNumber(169));
    }
}
