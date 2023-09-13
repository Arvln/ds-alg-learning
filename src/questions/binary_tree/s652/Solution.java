package questions.binary_tree.s652;

import java.util.HashMap;
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
    private HashMap<String, Integer> memo;
    private LinkedList<TreeNode> res;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        memo=new HashMap<>();
        res=new LinkedList<>();
        traverse(root);
        return res;
    }

    String traverse(TreeNode root) {
        if (root==null) return "#";

        String left=traverse(root.left);
        String right=traverse(root.right);
        // postorder
        String subTree=left+","+right+","+root.val;

        int freq=memo.getOrDefault(subTree, 0);
        if (freq==1) {
            res.add(root);
        }

        memo.put(subTree, freq+1);
        return subTree;
    }
}
