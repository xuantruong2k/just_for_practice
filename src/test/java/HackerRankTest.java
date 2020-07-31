import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import teddy.hackerrank.HackerRank;

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
}
