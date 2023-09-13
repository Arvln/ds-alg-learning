package heap;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestPractice {
    @Test
    public void testFindKthLargest() {
        int[] num1 = {3, 2, 1, 5, 6, 4};
        int[] num2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] num3 = {4, 5, 8, 2};
        Practice p1 = new Practice(num1, 2);
        Practice p2 = new Practice(num2, 4);
        Practice p3 = new Practice(num3, 3);

        assertEquals(5, p1.findKthLargest());
        assertEquals(4, p2.findKthLargest());
        assertEquals(4, p3.findKthLargest());
        assertEquals(4, p3.add(3));
        assertEquals(5, p3.add(5));
        assertEquals(5, p3.add(10));
        assertEquals(8, p3.add(9));
        assertEquals(8, p3.add(4));
    }
}
