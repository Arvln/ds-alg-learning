package heap;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestMaxHeap {
    @Test
    public void testConstructor() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        MaxHeap maxHeap = new MaxHeap(array);

        assertEquals("[7, 5, 6, 4, 2, 1, 3]", Arrays.toString(maxHeap.array));
    }

    @Test
    public void testOrder() {
        int[] unOrder = {5, 3, 2, 6, 1, 4};

        MaxHeap heap = new MaxHeap(unOrder);
        heap.order();
        assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(heap.array));
    }
}
