package practices.binary_tree.s101;

import practices.binary_tree.TreeNode;

public class Solution {
    private boolean isSymmetric=true;
    public boolean isSymmetric1(TreeNode root) {
        traverse(root.left, root.right);
        return isSymmetric;
    }

    void traverse(TreeNode p, TreeNode q) {
        if (p==null && q==null) return;
        if (p==null || q==null || p.val!=q.val) {
            isSymmetric=false;
            return;
        }

        traverse(p.left, q.right);
        traverse(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if (p==null || q==null || p.val!=q.val) return false;

        boolean isLeftSymmetric=isSymmetric(p.left, q.right);
        boolean isRightSymmetric=isSymmetric(p.right, q.left);

        return isLeftSymmetric && isRightSymmetric;
    }
}
