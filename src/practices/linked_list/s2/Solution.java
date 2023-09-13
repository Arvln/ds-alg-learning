package practices.linked_list.s2;

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

    private static int cal(int sum, ListNode p) {
        if (sum<10) {
            p.next=new ListNode(sum);
            return 0;
        } else {
            p.next=new ListNode(sum%10);
            return 1;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel=new ListNode(63), p=sentinel;
        int carry=0;
        while (l1!=null && l2!=null) {
            int sum=l1.val+l2.val+carry;
            carry=cal(sum, p);
            p=p.next;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null) {
            int sum=l1.val+carry;
            carry=cal(sum, p);
            p=p.next;
            l1=l1.next;
        }
        while (l2!=null) {
            int sum=l2.val+carry;
            carry=cal(sum, p);
            p=p.next;
            l2=l2.next;
        }
        if (carry!=0) p.next=new ListNode(carry);

        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        listNode1.next=new ListNode(9);
        listNode1.next.next=new ListNode(9);
        listNode1.next.next.next=new ListNode(9);
        listNode1.next.next.next.next=new ListNode(9);
        listNode1.next.next.next.next.next=new ListNode(9);
        ListNode listNode2 = new ListNode(9);
        listNode2.next=new ListNode(9);
        listNode2.next.next=new ListNode(9);
        listNode2.next.next.next=new ListNode(9);

        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        while (listNode!=null) {
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
