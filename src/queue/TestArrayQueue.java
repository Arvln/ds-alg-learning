package queue;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayQueue {
    @Test
    public void testOffer() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(2);

        queue.offer(1);
        assertTrue(queue.offer(2));
        assertIterableEquals(Arrays.asList(1, 2), queue);
        assertFalse(queue.offer(3));
    }

    @Test
    public void testPoll() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(2);

        queue.offer(1);
        queue.offer(2);
        queue.poll();

        assertIterableEquals(Arrays.asList(2), queue);
        assertEquals(2, queue.poll());
        assertNull(queue.poll());
    }

    @Test
    public void testPeak() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(2);

        assertNull(queue.peek());
        queue.offer(1);
        queue.offer(2);
        assertEquals(1, queue.peek());
    }

    @Test
    public void testIsEmpty() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(1);

        assertTrue(queue.isEmpty());
        queue.offer(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testIsFull() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(1);

        assertFalse(queue.isFull());
        queue.offer(1);
        assertTrue(queue.isFull());
    }
}
