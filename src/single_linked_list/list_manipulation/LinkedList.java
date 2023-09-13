package single_linked_list.list_manipulation;

public class LinkedList {
    public static Node reverse1(Node head) {
        Node newHead = null;
        for(Node current = head; current != null; current = current.next){
            newHead = new Node(current.value, newHead);
        }
        return newHead;
    }

    private static Node reverse2Helper(Node head, Node newHead) {
        if (head == null) return newHead;

        return reverse2Helper(head.next, new Node(head.value, newHead));
    }

    public static Node reverse2(Node head) {
        return reverse2Helper(head, null);
    }

    public static Node delete1(Node head, int value) {
        if (head == null) return null;

        Node s = new Node(63, head);
        Node current = s;
        Node next = s.next;

        while (next != null) {
            if (next.value == value) {
                current.next = next.next;
            } else {
                current = current.next;
            }
            next = next.next;
        }

        return s.next;
    }

    public static Node delete2(Node head, int value) {
        if (head == null) return null;
        if (head.value == value) return delete2(head.next, value);

        head.next = delete2(head.next, value);
        return head;
    }

    public static Node deleteLast1(Node head, int n) {
        Node s = new Node(63, head);
        Node current = s;
        Node next = s.next;
        while (next != null) {
            if (n > 0) {
                n = n - 1;
            } else {
                current = current.next;
            }
            next = next.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
        return s.next;
    }

    private static int deleteLast2Helper(Node current, Node next, int n) {
        if (next == null) return n;

        int last = deleteLast2Helper(current.next, next.next, n);
        last = last - 1;
        if (last == 0) {
            current.next = next.next;
        }
        return last;
    }

    public static Node deleteLast2(Node head, int n) {
        Node s = new Node(63, head);
        deleteLast2Helper(s, s.next, n);
        return s.next;
    }

    public static Node deleteDuplicate1(Node head) {
        Node s = new Node(63, head);
        Node current = s;
        Node next = s.next;

        while (next != null){
            if (current.value == next.value) {
                current.next = next.next;
            } else {
                current = current.next;
            }

            next = next.next;
        }
        return s.next;
    }

    private static Node deleteDuplicate2Helper(Node head, int currentValue) {
        if (head == null) return null;
        if (head.value == currentValue) {
            return deleteDuplicate2Helper(head.next, currentValue);
        } else {
            head.next = deleteDuplicate2Helper(head.next, head.value);
            return head;
        }
    }

    public static Node deleteDuplicate2(Node head) {
        return deleteDuplicate2Helper(head, head.value - 1);
    }

    public static Node deleteAllDuplicate1(Node head) {
        if (head == null || head.next == null) return head;

        Node s = new Node(63, head);
        Node first = s;
        Node second = first.next;
        Node third = second.next;

        while (third != null) {
            if (second.value == third.value) {
                while (third != null && third.value == second.value) {
                    third = third.next;
                }
                first.next = third;
            } else {
                first = first.next;
            }

            second = first.next;
            third = second.next;
        }

        return s.next;
    }

    public static Node deleteAllDuplicate2(Node head) {
        if (head == null || head.next == null) return head;

        if (head.value == head.next.value) {
            Node tmp = head.next.next;

            while (tmp != null && tmp.value == head.value) {
                tmp = tmp.next;
            }

            return deleteAllDuplicate2(tmp);
        } else {
            head.next = deleteAllDuplicate2(head.next);
            return head;
        }
    }

    public static Node merge1(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Node s = new Node(63, null);
        Node current = s;

        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        if (l1 == null) current.next = l2;
        if (l2 == null) current.next = l1;

        return s.next;
    }

    public static Node merge2(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.value < l2.value) {
            return new Node(l1.value, merge2(l1.next, l2));
        } else if (l1.value > l2.value) {
            return new Node(l2.value, merge2(l1, l2.next));
        } else {
            return new Node(l1.value, new Node(l2.value, merge2(l1.next, l2.next)));
        }
    }

    public static Node mergeAll1(Node head) {
        if (head == null) return null;

        Node s = new Node(63, null);
        s.next = head.valueRef;
        head = head.next;

        while (head != null){
            Node node = head.valueRef;
            if (node != null) {
                Node prev = s;
                Node current = prev.next;
                while (node != null) {
                    if (current == null) {
                        prev.next = node;
                        break;
                    } else if (node.value < current.value) {
                        prev.next = new Node(node.value, current);
                        prev = prev.next;
                    } else {
                        while (
                                current.next != null &&
                                (current.value == current.next.value ||
                                node.value > current.next.value)
                        ) {
                            prev = prev.next;
                            current = current.next;
                        }
                        current.next = new Node(node.value, current.next);
                        prev = current;
                        current = current.next;
                    }
                    node = node.next;
                }
            }
            head = head.next;
        }

        return s.next;
    }

    private static class MinHeap {
        private int[] array;
        private int size;

        @SuppressWarnings("all")
        public MinHeap(int capacity) {
            array = new int[capacity];
        }

        private void up(int value) {
            int child = size;
            int parent = (child - 1) / 2;

            while (child > 0 && array[parent] > value) {
                swap(child, parent);
                child = parent;
                parent = (child - 1) / 2;
            }
            array[child] = value;
        }

        public boolean offer(int value) {
            if (isFull()) return false;

            up(value);
            size = size + 1;
            return true;
        }

        private void swap(int current, int target) {
            int tmp = array[current];
            array[current] = array[target];
            array[target] = tmp;
        }

        private void down(int parent) {
            int left = 2 * parent + 1;
            int right = left + 1;
            int min = parent;

            if (left < size && array[left] < array[min]) {
                min = left;
            }
            if (right < size && array[right] < array[min]) {
                min = right;
            }
            if (min != parent) {
                swap(min, parent);
                down(min);
            }
        }

        public Integer poll() {
            if (isEmpty()) return null;

            swap(0, size - 1);
            size = size - 1;
            int removed = array[size];
            down(0);
            return removed;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == array.length;
        }
    }

    @SuppressWarnings("all")
    public static Node mergeAll2(Node head) {
        if (head == null) return null;

        MinHeap heap = new MinHeap(8);

        while (head != null) {
            Node current = head.valueRef;
            while (current != null) {
                heap.offer(current.value);
                current = current.next;
            }
            head = head.next;
        }

        Node s = new Node(63, null);
        Node current = s;

        while (!heap.isEmpty()) {
            current.next = new Node(heap.poll(), null);
            current = current.next;
        }

        return s.next;
    }
}
