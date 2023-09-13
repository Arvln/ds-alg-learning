package practices.binary_tree.s270;

import practices.binary_tree.TreeNode;

public class Solution {
    private int res=0;
    public int closestValue(TreeNode root, double target) {
        traverse(root, target, Double.MAX_VALUE);
        return res;
    }

    void traverse(TreeNode root, double target, double gap) {
        if (root==null) return;

        if (gap>Math.abs(target-root.val)) {
            gap=Math.abs(target-root.val);
            res=root.val;
        }

        if (root.val>target) traverse(root.left, target, gap);
        else traverse(root.right, target, gap);
    }
}
