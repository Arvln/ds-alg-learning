package practices.linked_list.s1836;

import java.util.HashMap;

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

    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        ListNode sentinel=new ListNode(63), p=head, slow=sentinel, fast=head;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (p!=null) {
            map.put(p.val, map.getOrDefault(p.val, 0)+1);
            p=p.next;
        }
        while (fast!=null) {
            if (map.get(fast.val)<2) {
                slow.next=fast;
                slow=slow.next;
            }
            fast=fast.next;
        }
        slow.next=null;

        return sentinel.next;
    }
}
