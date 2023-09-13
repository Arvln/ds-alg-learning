package practices.binary_tree.s865;

import practices.binary_tree.TreeNode;

public class Solution {
    private int maxDepth=Integer.MIN_VALUE;
    private TreeNode res;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        maxDepth(root, 0);
        return res;
    }

    int maxDepth(TreeNode root, int depth) {
        if (root==null) return depth;

        depth++;
        maxDepth=Math.max(maxDepth, depth);

        int left=maxDepth(root.left, depth);
        int right=maxDepth(root.right, depth);

        if (left==maxDepth&&right==maxDepth) {
            res=root;
        }
        return Math.max(left, right);
    }
}
