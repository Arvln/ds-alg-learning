package practices.binary_tree.s670;

import practices.binary_tree.TreeNode;

public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        return traverse(root, root.val);
    }

    int traverse(TreeNode root, int first) {
        if (root==null) return -1;
        if (root.val!=first) return root.val;

        int left=traverse(root.left, first);
        int right=traverse(root.right, first);

        if (left==-1) return right;
        if (right==-1) return left;

        return Math.min(left, right);
    }
}
