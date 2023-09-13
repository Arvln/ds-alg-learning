package single_linked_list;

import java.util.Iterator;
import java.util.function.Consumer;

public class SingleLinkedList implements Iterable<Integer> {
    private Node head = new Node(63, null);
    private int size = 0;

    private class NodeIterator implements Iterator<Integer> {
        Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
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

    private static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addFirst(int value) {
        head.next = new Node(value, head.next);
        size = size + 1 ;
    }

    public void addLast(int value) {
        if (size == 0) {
            addFirst(value);
            return;
        }

        Node target = findNode(size - 1);

        target.next = new Node(value, null);
        size = size + 1;
    }

    private Node findNode(int index) {
        if (size == 0) {
            throw new IllegalArgumentException("add at least one element into list.");
        }

        int currentIndex = 0;
        for (Node current = head.next;
             current != null;
             current = current.next, currentIndex = currentIndex + 1
        ) {
            if (currentIndex == index) {
                return current;
            }
        }

        throw new IllegalArgumentException(String.format("index %d is not valid.", index));
    }

    public int get(int index) {
        Node targetNode = findNode(index);

        return targetNode.value;
    }

    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }

        Node prev = findNode(index - 1);
        prev.next = new Node(value, prev.next);
        size = size + 1;
    }

    public void removeFirst() {
        Node targetNode = findNode(0);

        head.next = targetNode.next;
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }

        Node prev = findNode(index - 1);
        Node target = findNode(index);

        prev.next = target.next;
    }

    public int size() {
        return size;
    }

    public void loop1(Consumer<Integer> consumer) {
        Node current = head.next;

        while (current != null) {
            consumer.accept(current.value);
            current = current.next;
        }

        System.out.printf("size: %d%n", size);
    }

    public void loop2(Consumer<Integer> consumer) {
        for (Node current = head.next; current != null; current = current.next) {
            consumer.accept(current.value);
        }

        System.out.printf("size: %d%n", size);
    }

    public void loop3() {
        for (int value: this) {
            if (value == head.value) continue;

            System.out.println(value);
        }

        System.out.printf("size: %d%n", size);
    }
}
