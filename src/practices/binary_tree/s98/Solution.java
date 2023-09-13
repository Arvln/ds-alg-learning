package practices.binary_tree.s98;

import practices.binary_tree.TreeNode;

public class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;

        boolean left=isValidBST(root.left);

        if (prev!=null) {
            if (prev.val>=root.val) return false;
        }
        prev=root;

        boolean right=isValidBST(root.right);
        return left&&right;
    }
}
