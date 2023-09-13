package questions.binary_tree.s95;

import java.util.LinkedList;
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

    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new LinkedList<>();
        return build(1, n);
    }

    List<TreeNode> build(int low, int high) {
        List<TreeNode> res = new LinkedList<>();

        if (low>high) {
            res.add(null);
            return res;
        }

        for (int i = low; i <= high; i++) {
            List<TreeNode> leftTree=build(low, i-1);
            List<TreeNode> rightTree=build(i+1, high);

            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
