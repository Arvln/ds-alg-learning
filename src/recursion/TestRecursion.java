package recursion;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestRecursion {
    @Test
    public void testFib() {
        assertEquals(0, Recursion.fibonacci(0));
        assertEquals(1, Recursion.fibonacci(1));
        assertEquals(1, Recursion.fibonacci(2));
        assertEquals(2, Recursion.fibonacci(3));
        assertEquals(3, Recursion.fibonacci(4));
        assertEquals(5, Recursion.fibonacci(5));
        assertEquals(8, Recursion.fibonacci(6));
        assertEquals(13, Recursion.fibonacci(7));
        assertEquals(21, Recursion.fibonacci(8));
        assertEquals(34, Recursion.fibonacci(9));
        assertEquals(55, Recursion.fibonacci(10));
        assertEquals(89, Recursion.fibonacci(11));
    }
}
