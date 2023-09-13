package practices.binary_tree.s965;

import practices.binary_tree.TreeNode;

public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return isUnival(root, null);
    }

    boolean isUnival(TreeNode root, TreeNode parent) {
        if (root==null) return true;
        if (parent!=null&&parent.val!=root.val) return false;

        return isUnival(root.left, root)&&isUnival(root.right, root);
    }
}
