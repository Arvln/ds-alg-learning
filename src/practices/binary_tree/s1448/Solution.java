package practices.binary_tree.s1448;

import practices.binary_tree.TreeNode;

public class Solution {
    private int count=0;
    public int goodNodes(TreeNode root) {
        traverse(root, root.val);
        return count;
    }

    void traverse(TreeNode root, int max) {
        if (root==null) return;

        if (root.val>=max) {
            max=root.val;
            count++;
        }

        traverse(root.left, max);
        traverse(root.right, max);
    }
}
