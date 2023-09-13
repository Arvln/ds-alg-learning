package practices.linked_list.s82;

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(63);
        ListNode slow=sentinel, fast=head;
        int count=0;
        while (fast!=null) {
            ListNode next = fast.next;
            if (count<1 && (next==null || fast.val != next.val)) {
                fast.next = null;
                slow.next = fast;
                slow = slow.next;
            }
            count++;
            if (next!=null && fast.val!=next.val) {
                count=0;
            }
            fast=next;
        }

        return sentinel.next;
    }

    /**
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表
     *
     * tips
     * 1, 刪除重複項需要一個計數器，依照計數器當前數值來執行對應操作
     * 2, slow在元素第一次出現且下個元素為空或值不重複時修改數組，當fast發現新元素時計數器歸零
     *
     * */
}
