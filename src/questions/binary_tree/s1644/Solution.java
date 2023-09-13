package questions.binary_tree.s1644;

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

    private static HashSet<Integer> set=new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        set.add(p.val);
        set.add(q.val);

        TreeNode res=traverse(root, set);

        return set.size()==0 ? res : null;
    }

    TreeNode traverse(TreeNode root, HashSet<Integer> set) {
        if (root==null) return null;

        TreeNode left=traverse(root.left, set);
        TreeNode right=traverse(root.right, set);

        if (left!=null && right!=null) return root;
        if (set.contains(root.val)) {
            set.remove(root.val);
            return root;
        }

        return left!=null ? left : right;
    }
}
