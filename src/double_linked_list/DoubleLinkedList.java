package double_linked_list;

import java.util.Iterator;

public class DoubleLinkedList implements Iterable<Integer> {
    private static class Node {
        private Node prev;
        private int value;
        private Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() {
        head = new Node(null, 67, null);
        tail = new Node(null, 76, null);

        head.next = tail;
        tail.prev = head;
    }

    public int size() {
        return size;
    }

    public void addFirst(int value) {
        Node next = head.next;

        head.next = next.prev = new Node(head, value, next);
        size = size + 1;
    }

    public void removeFirst() {
        Node removed = head.next;
        Node next = removed.next;

        if (removed == tail) {
            throw new IndexOutOfBoundsException("Add at least one element before remove.");
        }

        head.next = next;
        next.prev = head;
        size = size - 1;
    }

    public void addLast(int value) {
        Node prev = tail.prev;

        prev.next = tail.prev = new Node(prev, value, tail);
        size = size + 1;
    }

    public void removeLast() {
        Node removed = tail.prev;
        Node prev = removed.prev;

        if (removed == head) {
            throw new IndexOutOfBoundsException("Add at least one element before remove.");
        }

        prev.next = tail;
        tail.prev = prev;
        size = size - 1;
    }

    private Node findNode(int index) {
        int position = -1;

        for(Node currentNode = head;
            currentNode != tail;
            currentNode = currentNode.next, position = position + 1
        ) {
            if (position == index) return currentNode;
        }

        throw new IllegalArgumentException(String.format("Index %d is not valid.", index));
    }

    public int get(int index) {
        if (size == 0) throw new IndexOutOfBoundsException("Add at least one element before query.");
        if (index < 0) throw new IllegalArgumentException("Index can not be negative.");

        return findNode(index).value;
    }

    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        Node next = prev.next;

        prev.next = next.prev = new Node(prev, value, next);
        size = size + 1;
    }

    public void remove(int index) {
        Node prev = findNode(index - 1);
        Node removed = prev.next;
        Node next = removed.next;

        if (removed == tail) {
            throw new IndexOutOfBoundsException("Add at least one element before remove.");
        }

        prev.next = next;
        next.prev = prev;
        size = size - 1;
    }

    private class NodeIterator implements Iterator<Integer> {
        Node current = head.next;

        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public Integer next() {
            int value = current.value;

            current = current.next;
            return value;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new NodeIterator();
    }
}
