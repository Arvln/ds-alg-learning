package practices.binary_tree.s235;

import practices.binary_tree.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min=Math.min(p.val, q.val);
        int max=Math.max(p.val, q.val);
        return lowestCommonAncestor(root, min, max);
    }

    TreeNode lowestCommonAncestor(TreeNode root, int min, int max) {
        if (root==null) return null;

        if (root.val<min) return lowestCommonAncestor(root.right, min, max);
        else if (root.val>max) return lowestCommonAncestor(root.left, min, max);
        else return root;
    }
}
