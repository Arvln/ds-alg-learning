package single_linked_list.list_manipulation;

public class Node {
    int value;
    Node valueRef;
    Node next;

    public Node() {}
    public Node(int value) {
        this.value = value;
    }
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
    public Node(Node valueRef, Node next) {
        this.valueRef = valueRef;
        this.next = next;
    }

    public static String toString(Node head) {
        if (head == null) return "[]";

        int i = 0;
        StringBuilder result = new StringBuilder("[");
        for (Node current = head; current != null; current = current.next, i++) {
            result.append(current.value);
            if (current.next != null) {
               result.append(", ");
            } else {
                result.append("]");
            }
        }
        return result.toString();
    }
}
