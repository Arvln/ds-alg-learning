package practices.binary_tree.s104;

import practices.binary_tree.TreeNode;

public class Solution {
    private int depth=0, maxDepth=0;

    public int maxDepth1(TreeNode root) {
        traverse(root);
        return maxDepth;
    }

    void traverse(TreeNode root) {
        if (root==null) return;

        depth++;
        traverse(root.left);
        traverse(root.right);
        maxDepth=Math.max(maxDepth, depth);
        depth--;
    }

    public int maxDepth(TreeNode root) {
        if (root==null) return 0;

        int leftMaxDepth=maxDepth(root.left);
        int rightMaxDepth=maxDepth(root.right);

        return Math.max(leftMaxDepth, rightMaxDepth)+1;
    }
}
