package practices.binary_tree.s145;

import practices.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<Integer> res=new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root==null) return;

        traverse(root.left);
        traverse(root.right);
        res.add(root.val);
    }
}
