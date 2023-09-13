package practices.binary_tree.s1469;

import practices.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<Integer> res=new LinkedList<>();
    public List<Integer> getLonelyNodes(TreeNode root) {
        traverse(root, null);
        return res;
    }

    void traverse(TreeNode root, TreeNode parent) {
        if (root==null) return;

        if (parent!=null&&(parent.left==null||parent.right==null)) res.add(root.val);

        traverse(root.left, root);
        traverse(root.right, root);
    }
}
