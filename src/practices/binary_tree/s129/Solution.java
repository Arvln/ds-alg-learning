package practices.binary_tree.s129;

import practices.binary_tree.TreeNode;

public class Solution {
    private int sum=0;
    public int sumNumbers1(TreeNode root) {
        traverse(root, 0);
        return sum;
    }

    void traverse(TreeNode root, int curVal) {
        if (root==null) return;

        curVal=curVal*10+root.val;

        traverse(root.left, curVal);
        traverse(root.right, curVal);

        if (root.left==null && root.right==null) sum+=curVal;
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    int sumNumbers(TreeNode root, int curVal) {
        if (root==null) return 0;

        curVal=curVal*10+root.val;
        if (root.left==null && root.right==null) return curVal;

        int leftSum=sumNumbers(root.left, curVal);
        int rightSum=sumNumbers(root.right, curVal);

        return leftSum+rightSum;
    }
}
