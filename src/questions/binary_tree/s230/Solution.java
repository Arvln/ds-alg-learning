package questions.binary_tree.s230;

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

    private int rank=0, res=0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    void traverse(TreeNode root, int k) {
        if (root==null) return;

        traverse(root.left, k);
        rank++;
        if (k==rank) {
            res=root.val;
            return;
        }
        traverse(root.right, k);
    }
}
