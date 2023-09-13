package practices.binary_tree.s366;

import practices.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root==null) return res;

        List<Integer> collector=new LinkedList<>();
        collectLeafNode(root.left, collector);
        collectLeafNode(root.right, collector);
        res.add(collector);

        findLeaves(root);
        return res;
    }

    TreeNode collectLeafNode(TreeNode root, List<Integer> collector) {
        if (root==null) return null;

        root.left=collectLeafNode(root.left, collector);
        root.right=collectLeafNode(root.right, collector);

        if (root.left==null&&root.right==null) {
            collector.add(root.val);
            return null;
        }

        return root;
    }
}
