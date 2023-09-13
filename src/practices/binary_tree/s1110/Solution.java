package practices.binary_tree.s1110;

import practices.binary_tree.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<TreeNode> res=new LinkedList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> toDelete=new HashSet<>();
        for (int deleted : to_delete) toDelete.add(deleted);

        root=traverse(root, toDelete);
        if (root!=null) res.add(root);
        return res;
    }

    TreeNode traverse(TreeNode root, HashSet<Integer> to_delete) {
        if (root==null) return null;

        root.left=traverse(root.left, to_delete);
        root.right=traverse(root.right, to_delete);

        if (to_delete.contains(root.val)) {
            if (root.left!=null) res.add(root.left);
            if (root.right!=null) res.add(root.right);
            return null;
        }

        return root;
    }
}
