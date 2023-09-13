package practices.binary_tree.s257;

import practices.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<String> res=new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root, "");
        return res;
    }

    void traverse(TreeNode root, String s) {
        if (root==null) return;

        s+=root.val;
        if (root.left==null&&root.right==null) {
            res.add(s);
            return;
        }

        traverse(root.left, s+"->");
        traverse(root.right, s+"->");
    }
}
