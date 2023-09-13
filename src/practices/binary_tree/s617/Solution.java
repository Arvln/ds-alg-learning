package practices.binary_tree.s617;

import practices.binary_tree.TreeNode;

public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    TreeNode merge(TreeNode r1, TreeNode r2) {
        if (r1==null) return r2;
        if (r2==null) return r1;

        TreeNode cur=new TreeNode(r1.val+r2.val);

        cur.left=mergeTrees(r1.left, r2.left);
        cur.right=mergeTrees(r1.right, r2.right);

        return cur;
    }
}
