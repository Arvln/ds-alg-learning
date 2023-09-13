package practices.binary_tree.s1644;

import practices.binary_tree.TreeNode;

public class Solution {
    private static boolean foundP, foundQ;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res=commonAncestor(root, p, q);

        if (!foundP||!foundQ) return null;
        return res;
    }
    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;

        TreeNode left=commonAncestor(root.left, p, q);
        TreeNode right=commonAncestor(root.right, p, q);

        if (root.val==p.val||root.val==q.val) {
            if (root.val==p.val) foundP=true;
            if (root.val==q.val) foundQ=true;
            return root;
        }
        else if (left==null) return right;
        else if (right==null) return left;
        return root;
    }
}
