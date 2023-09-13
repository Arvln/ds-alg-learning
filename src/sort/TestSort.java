package sort;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
    @Test
    public void testBubbleSort() {
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] actual = {5, 3, 6, 4, 2, 1};

        Sort.bubbleSort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSelectedSort() {
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] actual = {5, 3, 6, 4, 2, 1};

        Sort.selectedSort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSort() {
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] actual = {5, 3, 6, 4, 2, 1};

        Sort.insertionSort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSingleSideQuickSort() {
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] actual = {5, 3, 6, 4, 2, 1};

        Sort.quickSort(actual);

        assertArrayEquals(expected, actual);
    }
}
