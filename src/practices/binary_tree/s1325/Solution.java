package practices.binary_tree.s1325;

import practices.binary_tree.TreeNode;

public class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return deleteTarget(root, target);
    }

    TreeNode deleteTarget(TreeNode root, int target) {
        if (root==null) return null;

        root.left=deleteTarget(root.left, target);
        root.right=deleteTarget(root.right, target);

        if (root.left==null && root.right==null && root.val==target) return null;

        return root;
    }
}
