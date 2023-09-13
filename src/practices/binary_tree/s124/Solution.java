package practices.binary_tree.s124;

import practices.binary_tree.TreeNode;

public class Solution {
    private int maxPathSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxPathSum;
    }

    int maxSum(TreeNode root) {
        if (root==null) return 0;

        int leftSum=maxSum(root.left);
        int rightSum=maxSum(root.right);

        maxPathSum=Math.max(maxPathSum, leftSum+rightSum+root.val);
        return Math.max(root.val+Math.max(leftSum, rightSum), 0);
    }
}
