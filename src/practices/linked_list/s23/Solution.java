package practices.linked_list.s23;

import java.util.Comparator;
import java.util.PriorityQueue;

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

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode list : lists) {
            if (list!=null) pq.offer(list);
        }

        ListNode sentinel = new ListNode(63), p=sentinel;

        while (!pq.isEmpty()) {
            ListNode poll =pq.poll();
            p.next=poll;
            if (poll.next!=null) pq.offer(poll.next);
            p=p.next;
        }
        p.next=null;

        return sentinel.next;
    }
}
