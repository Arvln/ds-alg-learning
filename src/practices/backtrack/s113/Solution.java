package practices.backtrack.s113;

import practices.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new LinkedList<>();
        backtrack(root, new LinkedList<>(), targetSum,  res);
        return res;
    }
    private void backtrack(TreeNode root, LinkedList<Integer> track, int targetSum, List<List<Integer>> res) {
        if (root==null) return;

        track.add(root.val);
        backtrack(root.left, track, targetSum-root.val, res);
        backtrack(root.right, track, targetSum-root.val, res);
        if (root.left==null&&root.right==null&&targetSum==root.val) res.add(new LinkedList<>(track));

        track.removeLast();
    }
}
