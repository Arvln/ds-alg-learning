package questions.binary_tree.s144;

import java.util.ArrayList;
import java.util.List;

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
    private List<Integer> res;

    public List<Integer> preorderTraversal1(TreeNode root) {
        res=new ArrayList<>();
        traverse(root);
        return res;
    }
    void traverse(TreeNode root) {
        if (root==null) return;

        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;

        res.add(root.val);
        res.addAll(preorderTraversal2(root.left));
        res.addAll(preorderTraversal2(root.right));
        return res;
    }
}
