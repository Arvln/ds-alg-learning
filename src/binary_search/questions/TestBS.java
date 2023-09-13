package binary_search.questions;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestBS {
    @Test
    public void testQ1() {
        int[] nums = {-1, 0, 3, 3, 3, 5, 9, 12};

        assertEquals(6, Q1.binarySearch(nums, 9));
        assertEquals(2, Q1.binarySearch(nums, 3));
        assertEquals(-1, Q1.binarySearch(nums, 2));
    }

    @Test
    public void testQ2() {
        int[] nums = {1, 3, 5, 5, 5, 6, 6, 6};

        assertEquals(2, Q2.getInsertPoint(nums, 5));
        assertEquals(1, Q2.getInsertPoint(nums, 2));
        assertEquals(2, Q2.getInsertPoint(nums, 4));
        assertEquals(5, Q2.getInsertPoint(nums, 6));
        assertEquals(8, Q2.getInsertPoint(nums, 7));
    }

    @Test
    public void testQ3() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] eightInterval = {3, 4};
        int[] noFoundInterval = {-1, -1};

        assertArrayEquals(eightInterval, Q3.getInterval(nums, 8));
        assertArrayEquals(noFoundInterval, Q3.getInterval(nums, 6));
        assertArrayEquals(noFoundInterval, Q3.getInterval(nums, 0));
    }
}
