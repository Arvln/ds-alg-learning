package questions.linked_list.s23;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
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
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode sentinel = new ListNode(67);
        ListNode p = sentinel;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b)->a.val-b.val);

        for (ListNode list : lists) {
            if (list!=null) pq.offer(list);
        }

        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            if (cur.next!=null) pq.offer(cur.next);

            p.next = cur;
            p = p.next;
        }

        p.next = null;
        return sentinel.next;
    }
}