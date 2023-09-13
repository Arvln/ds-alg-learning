package practices.binary_tree.s404;

import practices.binary_tree.TreeNode;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return leftLeafSum(root, null);
    }

    int leftLeafSum(TreeNode root, TreeNode parent) {
        if (root==null) return 0;

        int left=leftLeafSum(root.left, root);
        int right=leftLeafSum(root.right, root);

        if (root.left==null&&root.right==null&&parent!=null&&root==parent.left) {
            return left+right+root.val;
        }
        return left+right;
    }
}
