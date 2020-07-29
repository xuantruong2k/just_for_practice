package teddy.hackerrank;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class HackerRankTest {

    @Test
    public void testMatchingString() {

        String[] strings = new String[]{"def", "de", "fgh"};
        String[] queries = new String[]{"de", "lmn", "fgh"};
        int[] result = HackerRank.matchingStrings(strings, queries);
        int[] expect = new int[] {1, 0, 1};

        assertArrayEquals(result, expect);
    }
}
