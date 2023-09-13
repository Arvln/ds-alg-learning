package practices.linked_list.s83;

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow=head, fast=head;
        while (fast!=null) {
            if (fast.val!=slow.val) {
                slow.next=fast;
                slow=slow.next;
            }
            fast=fast.next;
        }
        if (slow!=null) slow.next=null;

        return head;
    }
}
