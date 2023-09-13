package practices.binary_tree.s110;

import practices.binary_tree.TreeNode;

public class Solution {
    private boolean isBalanced=true;
    public boolean isBalanced1(TreeNode root) {
        traverse(root);
        return isBalanced;
    }

    int traverse(TreeNode root) {
        if (root==null || !isBalanced) return 0;

        int leftMaxDepth=traverse(root.left);
        int rightMaxDepth=traverse(root.right);
        isBalanced=isBalanced&&Math.abs(leftMaxDepth-rightMaxDepth)<=1;

        return Math.max(leftMaxDepth, rightMaxDepth)+1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        return Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    int maxDepth(TreeNode root) {
        if (root==null) return 0;

        int leftMaxDepth=maxDepth(root.left);
        int rightMaxDepth=maxDepth(root.right);

        return Math.max(leftMaxDepth, rightMaxDepth)+1;
    }
}
