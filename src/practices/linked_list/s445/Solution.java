package practices.linked_list.s445;

import java.util.Stack;

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        while (l1!=null) {
            s1.push(l1.val);
            l1=l1.next;
        }
        Stack<Integer> s2 = new Stack<>();
        while (l2!=null) {
            s2.push(l2.val);
            l2=l2.next;
        }

        ListNode s=new ListNode(63);
        int carry=0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry!=0) {
            int sum=carry;

            if (!s1.isEmpty()) {
                sum+= s1.pop();
            }
            if (!s2.isEmpty()) {
                sum+= s2.pop();
            }

            if (sum<10) {
                s.next=new ListNode(sum, s.next);
                carry=0;
            } else {
                s.next=new ListNode(sum%10, s.next);
                carry=1;
            }
        }

        return s.next;
    }
}
