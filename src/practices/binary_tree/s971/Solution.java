package practices.binary_tree.s971;

import practices.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private ArrayList<Integer> res=new ArrayList<>();
    private int[] voyage;
    private int i=0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage=voyage;
        traverse(root);
        if (!res.isEmpty() && res.get(0) == -1) {
            res.clear();
            res.add(-1);
        }

        return res;
    }

    void traverse(TreeNode root) {
        if (root==null) return;

        if (root.val!=voyage[i++]) {
            res.clear();
            res.add(-1);
            return;
        }
        if (i< voyage.length&&root.left!=null&&root.left.val!=voyage[i]) {
            res.add(root.val);
            traverse(root.right);
            traverse(root.left);
        } else {
            traverse(root.left);
            traverse(root.right);
        }
    }
}
