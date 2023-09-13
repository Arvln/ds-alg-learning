package practices.binary_tree.s1379;

import practices.binary_tree.TreeNode;

public class Solution {
    private TreeNode res;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        traverse(cloned, target.val);
        return res;
    }

    void traverse(TreeNode root, int target) {
        if (root==null) return;

        traverse(root.left, target);
        traverse(root.right, target);
        if (root.val==target) res=root;
    }
}
