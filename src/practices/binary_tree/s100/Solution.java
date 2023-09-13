package practices.binary_tree.s100;

import practices.binary_tree.TreeNode;

public class Solution {
    private boolean isSame=true;
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        traverse(p, q);
        return isSame;
    }

    void traverse(TreeNode p, TreeNode q) {
        if (p==null && q==null) return;

        if (p==null || q==null || p.val!=q.val) {
            isSame=false;
            return;
        }

        traverse(p.left, q.left);
        traverse(p.right, q.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if (p==null || q==null || p.val!=q.val) return false;

        boolean isLeftSame=isSameTree(p.left, q.left);
        boolean isRightSame=isSameTree(p.right, q.right);

        return isLeftSame && isRightSame;
    }
}
