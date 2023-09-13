package questions.binary_tree.s701;

public class Solution {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null) return new TreeNode(val);

        if (root.val>val) {
            root.left=insertIntoBST(root.left, val);
        }
        if (root.val<val) {
            root.right=insertIntoBST(root.right, val);
        }

        return root;
    }
}
