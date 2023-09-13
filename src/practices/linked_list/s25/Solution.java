package practices.linked_list.s25;

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

    private static ListNode reverseK(ListNode head, ListNode end, int k) {
        ListNode slow=end, fast=head;
        while (fast!=null && k>0) {
            ListNode next=fast.next;
            fast.next=slow;
            slow=fast;
            fast=next;
            k--;
        }
        return slow;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null) return null;
        ListNode start=head, end=head;

        for (int i = 0; i<k; i++) {
            if (end==null) return start;
            end=end.next;
        }

        end=reverseKGroup(end, k);
        return reverseK(start, end, k);
    }
}
