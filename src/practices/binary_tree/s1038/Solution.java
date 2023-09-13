package practices.binary_tree.s1038;

import practices.binary_tree.TreeNode;

public class Solution {
    public TreeNode bstToGst(TreeNode root) {
        traverse(root, 0);
        return root;
    }

    int traverse(TreeNode root, int sum) {
        if (root==null) return sum;

        int left=traverse(root.right, sum);

        root.val+=left;

        return traverse(root.left, root.val);
    }
}
