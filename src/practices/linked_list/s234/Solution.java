package practices.linked_list.s234;

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

    private static ListNode reverse(ListNode p) {
        ListNode slow=null, fast=p;
        while(fast!=null) {
            ListNode next=fast.next;
            fast.next=slow;
            slow=fast;
            fast=next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow=head, fast=head;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode last = reverse(slow);
        while (last!=null) {
            if (head.val!=last.val) return false;
            head=head.next;
            last=last.next;
        }

        return true;
    }
}
