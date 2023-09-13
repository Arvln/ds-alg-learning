package questions.design_ds.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

class LFUCache1 {
    private HashMap<Integer, Integer> keyToVal;
    private HashMap<Integer, Integer> keyToFreq;
    private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    private int capacity, minFreq;

    public LFUCache1(int capacity) {
        keyToVal=new HashMap<>();
        keyToFreq=new HashMap<>();
        freqToKeys=new HashMap<>();
        this.capacity=capacity;
        minFreq=0;
    }

    private void increaseFreq(int key) {
        int freq=keyToFreq.getOrDefault(key, 0);
        keyToFreq.put(key, freq+1);
        freqToKeys.putIfAbsent(freq+1, new LinkedHashSet<>());
        freqToKeys.get(freq+1).add(key);

        if (!freqToKeys.containsKey(freq)) {
            minFreq=1;
            return;
        }

        freqToKeys.get(freq).remove(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (freq==minFreq) minFreq++;
        }
    }

    private void removeLeastFreq() {
        LinkedHashSet<Integer> leastFreqKeys=freqToKeys.get(minFreq);
        int removedKey=leastFreqKeys.iterator().next();

        leastFreqKeys.remove(removedKey);
        if (leastFreqKeys.isEmpty()) freqToKeys.remove(minFreq);
        keyToVal.remove(removedKey);
        keyToFreq.remove(removedKey);
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;

        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity<=0) return;
        if (keyToVal.size()==capacity&&!keyToVal.containsKey(key)) removeLeastFreq();

        keyToVal.put(key, value);
        increaseFreq(key);
    }
}

class LFUCache {
    private static class Node {
        private int key, val, freq;
        private Node prev, next;

        public Node(int key, int val) {
            this.key=key;
            this.val=val;
            freq=1;
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
            Node first=head.next;
            if (first==tail) return null;

            remove(first);
            return first;
        }
    }
    private HashMap<Integer, Node> keyToNode;
    private HashMap<Integer, DoubleLinkedList> freqToCache;
    private int capacity, minFreq;

    public LFUCache(int capacity) {
        keyToNode=new HashMap<>();
        freqToCache=new HashMap<>();
        this.capacity=capacity;
        minFreq=0;
    }

    private void increaseFreq(int key) {
        Node node=keyToNode.get(key);
        int freq=node.freq;
        freqToCache.get(freq).remove(node);
        if (freqToCache.get(freq).size()==0) {
            freqToCache.remove(freq);
            if (freq==minFreq) minFreq++;
        }

        freqToCache.putIfAbsent(freq+1, new DoubleLinkedList());
        node.freq++;
        freqToCache.get(freq+1).addLast(node);
    }

    private void removeLeastFreq() {
        DoubleLinkedList cache=freqToCache.get(minFreq);
        Node removed=cache.removeFirst();

        if (removed==null) return;
        if (cache.size()==0) freqToCache.remove(minFreq);

        keyToNode.remove(removed.key);
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) return -1;

        increaseFreq(key);
        return keyToNode.get(key).val;
    }

    public void put(int key, int value) {
        if (capacity<=0) return;
        if (keyToNode.containsKey(key)) {
            keyToNode.get(key).val=value;
            increaseFreq(key);
            return;
        }
        if (keyToNode.size()==capacity) removeLeastFreq();

        Node inserted=new Node(key, value);
        keyToNode.put(key, inserted);
        freqToCache.putIfAbsent(1, new DoubleLinkedList());
        freqToCache.get(1).addLast(inserted);
        minFreq=1;
    }
}
