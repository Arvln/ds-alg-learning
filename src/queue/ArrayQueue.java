package queue;

import java.util.Iterator;

public class ArrayQueue<T> implements Queue<T>, Iterable<T> {
    private final T[] array;
    private int head = 0;
    private int tail = 0;

    @SuppressWarnings("all")
    public ArrayQueue(int capacity) {
        array = (T[]) new Object[capacity + 1];
    }

    @Override
    public boolean offer(T value) {
        if (isFull()) return false;

        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public T poll() {
        if (isEmpty()) return null;

        T value = array[head];
        head = (head + 1) % array.length;
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        int current = head;

        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public T next() {
            T value = array[current];
            current = (current + 1) % array.length;
            return value;
        }
    }
}
