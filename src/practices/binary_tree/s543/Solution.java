package practices.binary_tree.s543;

import practices.binary_tree.TreeNode;

public class Solution {
    private int maxDiameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxDiameter;
    }

    int traverse(TreeNode root) {
        if (root==null) return 0;

        int leftMaxDepth=traverse(root.left);
        int rightMaxDepth=traverse(root.right);
        maxDiameter=Math.max(maxDiameter, leftMaxDepth+rightMaxDepth);

        return Math.max(leftMaxDepth, rightMaxDepth)+1;
    }
}
