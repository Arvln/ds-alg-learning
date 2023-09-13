package practices.binary_tree.s652;

import practices.binary_tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private HashMap<String, Integer> memo=new HashMap<>();
    private List<TreeNode> res=new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }

    String serialize(TreeNode root) {
        if (root==null) return "#";

        String left=serialize(root.left);
        String right=serialize(root.right);

        String node=left+","+right+","+root.val;
        memo.put(node, memo.getOrDefault(node, 0)+1);
        if (memo.get(node)==2) res.add(root);

        return node;
    }
}
