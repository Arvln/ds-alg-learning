package deque;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayDeque1 {
    @Test
    public void testOffer() {
        ArrayDeque1<Integer> deque = new ArrayDeque1<>(3);

        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerLast(3);
        assertFalse(deque.offerFirst(4));
        assertIterableEquals(Arrays.asList(2, 1, 3), deque);
    }

    @Test
    public void testPoll() {
        ArrayDeque1<Integer> deque = new ArrayDeque1<>(7);

        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerFirst(4);
        deque.offerFirst(5);
        deque.offerFirst(6);
        deque.offerFirst(7);
        assertIterableEquals(Arrays.asList(7, 6, 5, 4, 1, 2, 3), deque);
        assertTrue(deque.isFull());

        assertEquals(7, deque.pollFirst());
        assertEquals(6, deque.pollFirst());
        assertEquals(3, deque.pollLast());
        assertEquals(2, deque.pollLast());
        assertEquals(1, deque.pollLast());
        assertEquals(4, deque.pollLast());
        assertEquals(5, deque.pollLast());
        assertNull(deque.pollLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testPeak() {
        ArrayDeque1<Integer> deque = new ArrayDeque1<>(7);

        deque.offerFirst(1);
        deque.offerLast(2);
        deque.offerFirst(3);
        deque.offerLast(4);

        assertEquals(4, deque.peakLast());
        assertEquals(3, deque.peakFirst());
    }
}
