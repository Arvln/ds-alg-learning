package practices.backtrack.s112;

import practices.binary_tree.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return backtrack(root, null, targetSum);
    }
    private boolean backtrack(TreeNode root, TreeNode parent, int targetSum) {
        if (root==null) return parent!=null&&parent.left==null&&parent.right==null&&targetSum==0;

        return backtrack(root.left, root, targetSum-root.val)||backtrack(root.right, root, targetSum-root.val);
    }
}
