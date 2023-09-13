package practices.binary_tree.s1022;

import practices.binary_tree.TreeNode;

public class Solution {
    private int sum=0;
    public int sumRootToLeaf1(TreeNode root) {
        traverse(root, 0);
        return sum;
    }

    void traverse(TreeNode root, int curVal) {
        if (root==null) return;

        curVal=curVal*2+root.val;
        traverse(root.left, curVal);
        traverse(root.right, curVal);
        if (root.left==null && root.right==null) sum+=curVal;
    }

    public int sumRootToLeaf(TreeNode root) {
        return subTreeSum(root, 0);
    }

    int subTreeSum(TreeNode root, int curVal) {
        if (root==null) return 0;

        curVal=curVal*2+root.val;

        int leftVal=subTreeSum(root.left, curVal);
        int rightVal=subTreeSum(root.right, curVal);
        if (root.left==null && root.right==null) return curVal;

        return leftVal+rightVal;
    }
}
