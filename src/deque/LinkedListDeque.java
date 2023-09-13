package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private static class Node<T> {
        private Node<T> prev;
        private T value;
        private Node<T> next;

        public Node(Node<T> prev, T value, Node<T> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> sentinel;
    private int capacity = Integer.MAX_VALUE;
    private int size = 0;

    {
        sentinel = new Node<>(null, null, null);
        sentinel.prev = sentinel.next = sentinel;
    }

    public LinkedListDeque() {}
    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean offerFirst(T value) {
        if (isFull()) return false;

        sentinel.next = sentinel.next.prev = new Node<>(sentinel, value, sentinel.next);
        size = size + 1;
        return true;
    }

    @Override
    public boolean offerLast(T value) {
        if (isFull()) return false;

        sentinel.prev = sentinel.prev.next = new Node<>(sentinel.prev, value, sentinel);
        size = size + 1;
        return true;
    }

    @Override
    public T pollFirst() {
        if (isEmpty()) return null;

        Node<T> removed = sentinel.next;
        Node<T> next = removed.next;
        sentinel.next = next;
        next.prev = sentinel;
        size = size - 1;
        return removed.value;
    }

    @Override
    public T pollLast() {
        if (isEmpty()) return null;

        Node<T> removed = sentinel.prev;
        Node<T> prev = removed.prev;
        sentinel.prev = prev;
        prev.next = sentinel;
        size = size - 1;
        return removed.value;
    }

    @Override
    public T peakFirst() {
        return sentinel.next.value;
    }

    @Override
    public T peakLast() {
        return sentinel.prev.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<T> iterator() {
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<T> {
        Node<T> current = sentinel.next;

        @Override
        public boolean hasNext() {
            return current != sentinel;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}
