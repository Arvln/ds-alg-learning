package queue;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestLinkedListQueue {
    @Test
    public void testOffer() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>(3);

        queue.offer(1);
        queue.offer(2);

        assertTrue(queue.offer(3));
        assertIterableEquals(Arrays.asList(1, 2, 3), queue);
        assertFalse(queue.offer(4));
    }

    @Test
    public void testPoll() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        queue.offer(1);
        queue.offer(2);

        queue.poll();
        assertIterableEquals(Arrays.asList(2), queue);
        assertEquals(2, queue.poll());
        assertNull(queue.poll());
    }

    @Test
    public void testPeek() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        assertNull(queue.peek());
        queue.offer(1);
        queue.offer(2);
        assertEquals(1, queue.peek());
    }

    @Test
    public void testIsEmpty() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        assertTrue(queue.isEmpty());
        queue.offer(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testIsFull() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>(1);

        assertFalse(queue.isFull());
        queue.offer(1);
        assertTrue(queue.isFull());
    }
}
