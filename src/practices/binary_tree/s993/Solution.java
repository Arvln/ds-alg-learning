package practices.binary_tree.s993;

import practices.binary_tree.TreeNode;

public class Solution {
    private int x, y, xd, yd;
    private TreeNode xn, yn;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x=x;
        this.y=y;
        traverse(root, null, 0);

        if (xn==null||yn==null) return xd==yd;

        return xd==yd&&xn.val!=y&&yn.val!=x;
    }

    void traverse(TreeNode root, TreeNode parent, int depth) {
        if (root==null) return;
        if (root.val==x) {
            if (parent!=null) {
                if (parent.left==root) xn=parent.right;
                else xn=parent.left;
            }
            xd=depth;
        }
        if (root.val==y) {
            if (parent!=null) {
                if (parent.left==root) yn=parent.right;
                else yn=parent.left;
            }
            yd=depth;
        }

        traverse(root.left, root, depth+1);
        traverse(root.right, root, depth+1);
    }
}
