package deque;

import java.util.Iterator;

public class ArrayDeque1<T> implements Deque<T>, Iterable<T> {
    private T[] array;
    private int head = 0;
    private int tail = 0;

    @SuppressWarnings("all")
    public ArrayDeque1(int capacity) {
        array = (T[])new Object[capacity + 1];
    }

    /**
     * 0 1 2 3 4
     * h t
     * @return
     */
    private int increment(int index) {
        if (index + 1 >= array.length) {
            return 0;
        } else {
            return index + 1;
        }
    }

    private int decrement(int index) {
        if (index < 1) {
            return array.length - 1;
        } else {
            return index - 1;
        }
    }

    @Override
    public boolean offerFirst(T value) {
        if (isFull()) return false;

        head = decrement(head);
        array[head] = value;
        return true;
    }

    @Override
    public boolean offerLast(T value) {
        if (isFull()) return false;

        array[tail] = value;
        tail = increment(tail);
        return true;
    }

    @Override
    public T pollFirst() {
        if (isEmpty()) return null;

        T removed = array[head];
        array[head] = null;
        head = increment(head);
        return removed;
    }

    @Override
    public T pollLast() {
        if (isEmpty()) return null;

        array[tail] = null;
        tail = decrement(tail);
        return array[tail];
    }

    @Override
    public T peakFirst() {
        if (isEmpty()) return null;

        return array[head];
    }

    @Override
    public T peakLast() {
        if (isEmpty()) return null;

        return array[decrement(tail)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        if (tail > head) {
            return tail - head == array.length - 1;
        } else {
            return head - 1 == tail;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementIterator();
    }

    private class ElementIterator implements Iterator<T> {
        int current = head;

        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public T next() {
            T value = array[current];
            current = increment(current);
            return value;
        }
    }
}
