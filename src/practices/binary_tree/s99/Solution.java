package practices.binary_tree.s99;

import practices.binary_tree.TreeNode;

public class Solution {
    private TreeNode prev, x, y;
    public void recoverTree(TreeNode root) {
        traverse(root);

        if (x!=null&&y!=null) {
            int tmp=x.val;
            x.val= y.val;
            y.val=tmp;
        }
    }

    void traverse(TreeNode root) {
        if (root==null) return;

        traverse(root.left);

        if (prev!=null) {
            if (prev.val>root.val) {
                y=root;
                if (x==null) {
                    x=prev;
                }
            }
        }
        prev=root;


        traverse(root.right);
    }
}
