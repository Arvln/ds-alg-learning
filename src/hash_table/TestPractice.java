package hash_table;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestPractice {
    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[]{0, 1}, Practice.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, Practice.twoSum(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{0, 1}, Practice.twoSum(new int[]{3, 3}, 6));
    }

    @Test
    public void testLengthOfLongestSubstring() {
        assertEquals(3, Practice.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, Practice.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, Practice.lengthOfLongestSubstring("pwwkew"));
        assertEquals(2, Practice.lengthOfLongestSubstring("abba"));
    }

    @Test
    public void testHasRedundant() {
        assertTrue(Practice.hasRedundant(new int[]{1, 2, 3, 1}));
        assertFalse(Practice.hasRedundant(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testFindUnique() {
        assertEquals(1, Practice.findUnique(new int[]{2, 2, 1}));
        assertEquals(4, Practice.findUnique(new int[]{4, 1, 2, 1, 2}));
    }
}
