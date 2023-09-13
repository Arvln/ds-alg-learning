package practices.binary_tree.s998;

import practices.binary_tree.TreeNode;

public class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root==null) return new TreeNode(val);

        if (root.val<val) {
            return new TreeNode(val, root, null);
        } else {
            root.right=insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
