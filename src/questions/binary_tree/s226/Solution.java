package questions.binary_tree.s226;

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

    public TreeNode invertTree1(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode root) {
        if (root==null) return;

        traverse(root.left);
        traverse(root.right);
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root==null) return null;

        TreeNode left=invertTree2(root.left);
        TreeNode right=invertTree2(root.right);

        root.left=right;
        root.right=left;
        return root;
    }
}
