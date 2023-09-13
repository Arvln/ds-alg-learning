package circle_linked_list;

import org.junit.Test;

import java.util.Iterator;
import java.util.function.Consumer;

public class CircleLinkedList implements Iterable<Integer> {
    private static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
    private Node sentinel;
    private int size = 0;

    public CircleLinkedList() {
        sentinel = new Node(null, 63, null);
        sentinel.prev = sentinel.next = sentinel;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<Integer> {
        Node currentNode = sentinel.next;

        @Override
        public boolean hasNext() {
            return currentNode != sentinel;
        }

        @Override
        public Integer next() {
            int value = currentNode.value;
            currentNode = currentNode.next;
            return value;
        }
    }

    public void addFirst(int value) {
        Node next = sentinel.next;

        sentinel.next = next.prev = new Node(sentinel, value, next);
        size = size + 1;
    }

    public void removeFirst() {
        Node removed = sentinel.next;
        Node next = removed.next;

        if (removed == sentinel){
            throw new IndexOutOfBoundsException("Add at least one element before remove.");
        }

        sentinel.next = next;
        next.prev = sentinel;
        size = size - 1;
    }

    public void addLast(int value) {
        Node prev = sentinel.prev;

        prev.next = sentinel.prev = new Node(prev, value, sentinel);
        size = size + 1;
    }

    public void removeLast() {
        Node removed = sentinel.prev;
        Node prev = removed.prev;

        if (removed == sentinel) {
            throw new IndexOutOfBoundsException("Add at least one element before remove.");
        }

        prev.next = sentinel;
        sentinel.prev = prev;
        size = size - 1;
    }

    private Node findNode(int index) {
        if (index == -1) return sentinel;

        int currentIndex = 0;

        for(
            Node currentNode = sentinel.next;
            currentNode != sentinel;
            currentNode = currentNode.next, currentIndex = currentIndex + 1
        ) {
            if (currentIndex == index) return currentNode;
        }

        throw new IllegalArgumentException(String.format("Index %d is not valid.", index));
    }

    public int get(int index) {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Add at least one element before query.");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index can not be negative.");
        }

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

        if (removed == sentinel) {
            throw new IndexOutOfBoundsException("Add at least one element before remove.");
        }

        prev.next = next;
        next.prev = prev;
        size = size - 1;
    }

    private void recursionHelper(Node currentNode, Consumer<Integer> consumer) {
        if (currentNode == sentinel) return;

        consumer.accept(currentNode.value);
        recursionHelper(currentNode.next, consumer);
    }

    public void recursion(Consumer<Integer> consumer) {
        recursionHelper(sentinel.next, consumer);
    }
}
