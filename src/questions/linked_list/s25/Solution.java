package questions.linked_list.s25;

public class Solution {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static ListNode reverseK(ListNode start, ListNode end, int k) {
        ListNode prev = end;

        while (start != null && k > 0) {
            ListNode next = start.next;
            start.next = prev;
            prev = start;
            start = next;
            k--;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        ListNode start=head, end=head;
        for (int i = 0; i < k; i++) {
            if (end == null) return start;
            end = end.next;
        }

        return reverseK(start, reverseKGroup(end, k), k);
    }
}
