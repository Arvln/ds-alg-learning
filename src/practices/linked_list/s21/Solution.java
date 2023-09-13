package practices.linked_list.s21;

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sentinel = new ListNode(63), p=sentinel;

        while (list1!=null && list2!=null) {
            if (list1.val<list2.val) {
                p.next=list1;
                list1=list1.next;
            } else {
                p.next=list2;
                list2=list2.next;
            }
            p=p.next;
        }
        if (list1!=null) p.next=list1;
        if (list2!=null) p.next=list2;

        return sentinel.next;
    }
}