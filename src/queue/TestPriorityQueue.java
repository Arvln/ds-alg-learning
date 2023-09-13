package queue;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPriorityQueue {
    private static class Entry implements Priority {
        private String value;
        private int priority;

        public Entry(String value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        @Override
        public int priority() {
            return priority;
        }
    }

    @Test
    public void testPoll() {
        PriorityQueue1<Entry> queue = new PriorityQueue1<>(5);

        queue.offer(new Entry("1", 4));
        queue.offer(new Entry("2", 3));
        queue.offer(new Entry("3", 2));
        queue.offer(new Entry("4", 5));
        queue.offer(new Entry("5", 1));
        assertFalse(queue.offer(new Entry("6", 6)));

        assertEquals(5, queue.poll().priority());
        assertEquals(4, queue.poll().priority());
        assertEquals(3, queue.poll().priority());
        assertEquals(2, queue.poll().priority());
        assertEquals(1, queue.poll().priority());
    }

    @Test
    public void testPoll2() {
        PriorityQueue2<Entry> queue = new PriorityQueue2<>(5);

        queue.offer(new Entry("1", 4));
        queue.offer(new Entry("2", 3));
        queue.offer(new Entry("3", 2));
        queue.offer(new Entry("4", 5));
        queue.offer(new Entry("5", 1));
        assertFalse(queue.offer(new Entry("6", 6)));

        assertEquals(5, queue.poll().priority());
        assertEquals(4, queue.poll().priority());
        assertEquals(3, queue.poll().priority());
        assertEquals(2, queue.poll().priority());
        assertEquals(1, queue.poll().priority());
    }
}
