package binary_search;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestBinarySearch {
    @Test
    public void testBinarySearch() {
        int[] orderArray = {1, 2, 2, 2, 2, 2, 5, 7, 57, 68, 79, 85, 100};

        assertEquals(-13, BinarySearch.search(orderArray, 86));
        assertEquals(5, BinarySearch.search(orderArray, 2));
        assertEquals(10, BinarySearch.search(orderArray, 79));
    }
}
