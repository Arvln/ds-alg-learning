package practices.binary_tree.s572;

import practices.binary_tree.TreeNode;

public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root==null) return false;
        return isSub(root, subRoot)||isSubtree(root.left, subRoot)||isSubtree(root.right, subRoot);
    }

    boolean isSub(TreeNode root, TreeNode subRoot) {
        if (subRoot==null) return root==null;
        if (root==null) return false;
        if (root.val!=subRoot.val) return false;

        return isSub(root.left, subRoot.left)&&isSub(root.right, subRoot.right);
    }
}
