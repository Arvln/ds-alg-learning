package bubble_sort;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
    @Test
    public void testBubbleSort() {
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] target = {2, 1, 3, 4, 5, 6};

        Sort.bubbleSort(target);
        assertArrayEquals(expected, target);
    }

    @Test
    public void testInsertionSort() {
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] target = {5, 6, 3, 4, 2, 1};

        Sort.insertionSort(target);
        assertArrayEquals(expected, target);
    }
}
