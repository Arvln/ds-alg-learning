package practices.linked_list.s24;

public class Solution {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    private static ListNode reverse(ListNode start, ListNode end) {
        ListNode slow=end, fast=start;
        int k=2;
        while (fast!=null && k>0) {
            ListNode next=fast.next;
            fast.next=slow;
            slow=fast;
            fast=next;
            k--;
        }
        return slow;
    }

    public ListNode swapPairs(ListNode head) {
        if (head==null) return null;
        ListNode start=head, end=head;

        for (int i = 0; i < 2; i++) {
            if (end==null) return start;
            end=end.next;
        }

        return reverse(start, swapPairs(end));
    }
}
