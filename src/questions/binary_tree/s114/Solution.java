package questions.binary_tree.s114;

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

    public void flatten(TreeNode root) {
        if (root==null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left=root.left;
        TreeNode right=root.right;

        root.left=null;
        root.right=left;
        while (root.right!=null) {
            root=root.right;
        }
        root.right=right;
    }
}
