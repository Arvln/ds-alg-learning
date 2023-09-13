package practices.linked_list.s92;

public class Solution {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    private static ListNode last;

    private static ListNode reverse(ListNode head, int len) {
        if (head==null || head.next==null || len==0) {
            if (head!=null) last=head.next;
            return head;
        }

        ListNode newHead = reverse(head.next, len-1);
        head.next.next=head;
        head.next=last;
        return newHead;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode s=new ListNode(63), slow=s, fast=head;
        s.next=head;

        while(fast!=null) {
            if (left==1) {
                slow.next=reverse(fast, right-left);
            }
            left--;
            right--;
            slow=slow.next;
            fast=fast.next;
        }

        return s.next;
    }
}
