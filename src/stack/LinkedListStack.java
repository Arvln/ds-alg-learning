package stack;

import java.util.Iterator;

public class LinkedListStack<T> implements Stack<T>, Iterable<T> {
    public LinkedListStack() {}

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int capacity = Integer.MAX_VALUE;
    private int size = 0;
    private Node<T> head = new Node<>(null, null);

    public int size() {
        return size;
    }

    @Override
    public boolean push(T value) {
        if (isFull()) return false;

        head.next = new Node<T>(value, head.next);
        size = size + 1;
        return true;
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;

        Node<T> first = head.next;
        head.next = first.next;
        size = size - 1;
        return first.value;
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;

        return head.next.value;
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
        Node<T> current = head.next;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}
