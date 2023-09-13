package stack;

import queue.Queue;

public class MockQueue<T> implements Queue<T> {
    private ArrayListStack<T> head;
    private ArrayListStack<T> tail;
    private int capacity;
    private int size = 0;

    public MockQueue(int capacity) {
        head = new ArrayListStack<>(capacity);
        tail = new ArrayListStack<>(capacity);
        this.capacity = capacity;
    }

    @Override
    public boolean offer(T value) {
        if (isFull()) return false;

        tail.push(value);
        size = size + 1;
        return true;
    }

    @Override
    public T poll() {
        if (head.isEmpty()) {
            while (!tail.isEmpty()) {
                head.push(tail.pop());
            }
        }

        size = size - 1;
        return head.pop();
    }

    @Override
    public T peek() {
        if (head.isEmpty()) {
            while (!tail.isEmpty()) {
                head.push(tail.pop());
            }
        }

        return head.peek();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
}
