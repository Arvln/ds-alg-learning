package questions.design_ds.lru;

import java.util.HashMap;

class LRUCache {
    private static class Node {
        private int key, val;
        private Node prev, next;

        public Node (int key, int val) {
            this.key=key;
            this.val=val;
        }
    }
    private static class DoubleLinkedList {
        private Node head, tail;
        private int size;

        public DoubleLinkedList() {
            head=new Node(0, 0);
            tail=new Node(0, 0);
            head.next=tail;
            tail.prev=head;
            size=0;
        }

        public int size() { return size; }

        public void addLast(Node n) {
            Node prev=tail.prev, next=tail;
            n.prev=prev;
            n.next=next;
            prev.next=next.prev=n;
            size++;
        }

        public void remove(Node n) {
            Node prev=n.prev, next=n.next;
            prev.next=next;
            next.prev=prev;
            size--;
        }

        public Node removeFirst() {
            if (head.next==tail) return null;

            Node first=head.next;
            remove(first);
            return first;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> map;
    private DoubleLinkedList cache;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        cache=new DoubleLinkedList();
    }

    private void makeRecently(int key) {
        if (!map.containsKey(key)) return;

        Node node=map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    private void removeLeastRecently() {
        Node first=cache.removeFirst();
        if (first==null) return;

        map.remove(first.key);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if (capacity<=0) return;
        if (map.containsKey(key)) cache.remove(map.get(key));
        if (cache.size()==capacity) removeLeastRecently();

        Node inserted=new Node(key, value);
        cache.addLast(inserted);
        map.put(key, inserted);
    }
}
