package practices.binary_tree.s538;

import practices.binary_tree.TreeNode;

public class Solution {
    private int sum=0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode root) {
        if (root==null) return;

        traverse(root.right);

        sum+=root.val;
        root.val=sum;

        traverse(root.left);
    }
}
