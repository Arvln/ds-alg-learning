package practices.binary_tree.s897;

import practices.binary_tree.TreeNode;

public class Solution {
    private TreeNode prev, head;

    public TreeNode increasingBST(TreeNode root) {
        if (root==null) return null;

        increasingBST(root.left);

        if (prev!=null) {
            prev.right=root;
        } else {
            head=root;
        }
        prev=root;
        prev.left=null;

        increasingBST(root.right);

        return head;
    }
}
