package questions.linked_list.s206;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode sentinel = new ListNode(63);

        while (head != null) {
            ListNode next = head.next;
            head.next = sentinel.next;
            sentinel.next = head;
            head = next;
        }

        return sentinel.next;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode last = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
