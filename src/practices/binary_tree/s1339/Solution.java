package practices.binary_tree.s1339;

import practices.binary_tree.TreeNode;

public class Solution {
    private int total=0;
    private long maxProduct=0;
    public int maxProduct1(TreeNode root) {
        traverse(root);
        subTreeSum(root);
        return (int) (maxProduct%(Math.pow(10, 9)+7));
    }

    void traverse(TreeNode root) {
        if (root==null) return;

        traverse(root.left);
        traverse(root.right);
        total+=root.val;
    }

    long subTreeSum(TreeNode root) {
        if (root==null) return 0;

        long leftSum=subTreeSum(root.left);
        long rightSum=subTreeSum(root.right);
        long leftProduct=leftSum*(total-leftSum), rightProduct=rightSum*(total-rightSum);

        maxProduct=Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        return leftSum+rightSum+root.val;
    }
}
