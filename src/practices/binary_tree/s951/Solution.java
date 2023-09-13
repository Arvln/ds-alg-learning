package practices.binary_tree.s951;

import practices.binary_tree.TreeNode;

public class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1==null) return root2==null;
        if (root2==null) return false;
        if (root1.val!=root2.val) return false;

        boolean left=flipEquiv(root1.left, root2.left)||flipEquiv(root1.left, root2.right);
        boolean right=flipEquiv(root1.right, root2.left)||flipEquiv(root1.right, root2.right);

        return left&&right;
    }
}
