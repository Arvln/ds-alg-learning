package queue;

import java.util.Iterator;

public class LinkedListQueue<T> implements Queue<T>, Iterable<T> {
    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> head = new Node<>(null, null);
    private Node<T> tail = head;
    private int size = 0;
    private int capacity = Integer.MAX_VALUE;

    {
        tail.next = head;
    }

    public LinkedListQueue() {}
    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    public int size() { return size; }

    @Override
    public boolean offer(T value) {
        if (isFull()) return false;

        Node<T> added = new Node<>(value, head);
        tail.next = added;
        tail = added;
        size = size + 1;
        return true;
    }

    @Override
    public T poll() {
        if (isEmpty()) return null;
        Node<T> first = head.next;
        head.next = first.next;
        if (head.next == head) {
            tail = head;
        }
        size = size - 1;
        return first.value;
    }

    @Override
    public T peek() {
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
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
        Node<T> current = head.next;

        @Override
        public boolean hasNext() {
            return current != head;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}
