package questions.linked_list.s92;

public class Solution {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static ListNode[] reverse(ListNode head, int length) {
        ListNode sentinel = new ListNode(63);
        ListNode tail = head;

        while (head != null && length > 0) {
            ListNode next = head.next;
            head.next = sentinel.next;
            sentinel.next = head;
            head = next;
            length--;
        }

        if (tail != null) tail.next = head;

        return new ListNode[]{sentinel.next, tail};
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinel = new ListNode(63);
        ListNode p = sentinel;
        int i = 1;

        while (head != null) {
            if (i==left) {
                ListNode[] res = reverse(head, right-left+1);
                p.next = res[0];
                p = head = res[1];
            } else {
                p.next = head;
                p = p.next;
            }

            head = head.next;
            i++;
        }

        return sentinel.next;
    }

    private static ListNode[] reverseHelper(ListNode head, int n) {
        if (n == 0) {
            return new ListNode[]{head, head.next};
        }

        ListNode[] res = reverseHelper(head.next, n-1);

        head.next.next = head;
        head.next = res[1];
        return res;
    }

    public ListNode reverseBetweenRecursive(ListNode head, int left, int right) {
        if (left==1) {
            ListNode[] res = reverseHelper(head, right-left);
            return res[0];
        }

        head.next = reverseBetweenRecursive(head.next, left-1, right-1);
        return head;
    }
}
