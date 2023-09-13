package questions.binary_tree.s1676;

import java.util.HashSet;

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

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> set = new HashSet<>();
        for (TreeNode node : nodes) {
            set.add(node.val);
        }
        return lowestCommonAncestor(root, set);
    }

    TreeNode lowestCommonAncestor(TreeNode root, HashSet<Integer> set) {
        if (root==null) return null;

        if (set.contains(root.val)) return root;

        TreeNode left=lowestCommonAncestor(root.left, set);
        TreeNode right=lowestCommonAncestor(root.right, set);

        if (left!=null && right!=null) return root;

        return left!=null ? left : right;
    }
}
