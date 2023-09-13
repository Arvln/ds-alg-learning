package practices.binary_tree.s298;

import practices.binary_tree.TreeNode;

public class Solution {
    private int res=0;
    public int longestConsecutive(TreeNode root) {
        traverse(root, Integer.MIN_VALUE, 0);
        return res;
    }

    void traverse(TreeNode root, int pVal, int count) {
        if (root==null) return;

        if (pVal+1==root.val) count++;
        else count=1;

        res=Math.max(res, count);

        traverse(root.left, root.val, count);
        traverse(root.right, root.val, count);
    }
}
