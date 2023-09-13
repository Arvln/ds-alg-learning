package practices.binary_tree.s113;

import practices.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum, new LinkedList<>());
        return res;
    }

    void traverse(TreeNode root, int targetSum, LinkedList<Integer> path) {
        if (root==null) return;

        targetSum-=root.val;
        path.addLast(root.val);

        traverse(root.left, targetSum, path);
        traverse(root.right, targetSum, path);

        if (root.left==null && root.right==null && targetSum==0) res.add(new LinkedList<>(path));
        path.removeLast();
    }
}
