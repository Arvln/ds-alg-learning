package practices.linked_list.s19;

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(63), slow=sentinel, fast=head;
        sentinel.next=head;

        while (n>0 && fast!=null) {
            fast=fast.next;
            n--;
        }

        while (fast!=null) {
            slow=slow.next;
            fast=fast.next;
        }

        if (slow.next!=null) slow.next=slow.next.next;

        return sentinel.next;
    }
}
