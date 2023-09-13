package practices.binary_tree.s687;

import practices.binary_tree.TreeNode;

public class Solution {
    private int max=Integer.MIN_VALUE;
    public int longestUnivaluePath(TreeNode root) {
        if (root==null) return 0;
        maxPath(root, null);
        return max;
    }

    int maxPath(TreeNode root, TreeNode parent) {
        if (root==null) return 0;

        int left=maxPath(root.left, root);
        int right=maxPath(root.right, root);

        max=Math.max(max, left+right);

        if (parent!=null&&root.val==parent.val) return Math.max(left, right)+1;
        else return 0;
    }
}
