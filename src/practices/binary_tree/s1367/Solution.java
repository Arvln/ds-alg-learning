package practices.binary_tree.s1367;

import practices.binary_tree.TreeNode;
import practices.linked_list.ListNode;

public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root==null) return false;
        return isSub(head, root)||isSubPath(head, root.left)||isSubPath(head, root.right);
    }

    boolean isSub(ListNode head, TreeNode root) {
        if (head==null) return true;
        if (root==null) return false;
        if (root.val!=head.val) return false;

        return isSub(head.next, root.left)||isSub(head.next, root.right);
    }
}
