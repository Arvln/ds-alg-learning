package practices.binary_tree.s530;

import practices.binary_tree.TreeNode;

public class Solution {
    private int minGap=Integer.MAX_VALUE;
    private TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return minGap;
    }

    void traverse(TreeNode root) {
        if (root==null) return;

        traverse(root.left);

        if (prev!=null) {
            minGap=Math.min(minGap, root.val-prev.val);
        }
        prev=root;

        traverse(root.right);
    }
}
