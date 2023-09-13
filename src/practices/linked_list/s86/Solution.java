package practices.linked_list.s86;

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

    public ListNode partition(ListNode head, int x) {
        ListNode s1=new ListNode(63), s2=new ListNode(67), p1=s1, p2=s2;

        while (head!=null) {
            if (head.val<x) {
                p1.next=head;
                p1=p1.next;
            } else {
                p2.next=head;
                p2=p2.next;
            }

            head=head.next;
        }
        p1.next=s2.next;
        p2.next=null;

        return s1.next;
    }
}
