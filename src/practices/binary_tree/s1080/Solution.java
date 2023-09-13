package practices.binary_tree.s1080;

import practices.binary_tree.TreeNode;

public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return sufficientSubset(root, limit, 0);
    }

    TreeNode sufficientSubset(TreeNode root, int limit, int sum) {
        if (root==null) return null;

        sum+=root.val;
        if (root.left == null && root.right == null) {
            return sum < limit ? null : root;
        }

        root.left = sufficientSubset(root.left, limit, sum);
        root.right = sufficientSubset(root.right, limit, sum);

        return root.left == null && root.right == null ? null : root;
    }
}
