package questions.binary_tree.s543;

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
    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter=0;
        maxDepth(root);
        return diameter;
    }

    private int maxDepth(TreeNode root) {
        if (root==null) return 0;

        int leftMaxDepth=maxDepth(root.left);
        int rightMaxDepth=maxDepth(root.right);
        diameter=Math.max(diameter, leftMaxDepth+rightMaxDepth);

        return Math.max(leftMaxDepth, rightMaxDepth)+1;
    }
}
