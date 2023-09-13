package questions.binary_tree.s235;

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min=Math.min(p.val, q.val);
        int max=Math.max(p.val, q.val);
        return find(root, min, max);
    }

    private TreeNode find(TreeNode root, int min, int max) {
        if (root==null) return null;

        if (root.val<min) {
            return find(root.right, min, max);
        }
        if (root.val>max) {
            return find(root.left, min, max);
        }

        return root;
    }
}
