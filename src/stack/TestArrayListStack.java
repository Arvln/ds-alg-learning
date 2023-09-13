package stack;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayListStack {
    @Test
    public void testPush() {
        ArrayListStack<Integer> stack = new ArrayListStack<>(2);

        assertTrue(stack.push(2));
        assertTrue(stack.push(1));
        assertFalse(stack.push(0));
        assertIterableEquals(Arrays.asList(1, 2), stack);
    }

    @Test
    public void testPop() {
        ArrayListStack<Integer> stack = new ArrayListStack<>(1);

        assertNull(stack.pop());
        stack.push(1);
        assertEquals(1, stack.pop());
        assertNull(stack.pop());
    }

    @Test
    public void testPeak() {
        ArrayListStack<Integer> stack = new ArrayListStack<>(1);

        assertNull(stack.peek());
        stack.push(1);
        assertEquals(1, stack.peek());
        assertIterableEquals(Arrays.asList(1), stack);
    }

    @Test
    public void testIsEmpty() {
        ArrayListStack<Integer> stack = new ArrayListStack<>(1);

        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsFull() {
        ArrayListStack<Integer> stack = new ArrayListStack<>(1);

        assertFalse(stack.isFull());
        stack.push(1);
        assertTrue(stack.isFull());
        stack.pop();
        assertFalse(stack.isFull());
    }
}
