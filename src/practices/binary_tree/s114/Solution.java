package practices.binary_tree.s114;

import practices.binary_tree.TreeNode;

public class Solution {
    public void flatten(TreeNode root) {
        if (root==null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left=root.left, right=root.right;

        root.right=left;
        root.left=null;
        while (root.right!=null) root=root.right;
        root.right=right;
    }
}
