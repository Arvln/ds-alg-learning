package practices.binary_tree.s1676;

import practices.binary_tree.TreeNode;

import java.util.HashSet;

public class Solution {
    HashSet<Integer> allNodes=new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        for (TreeNode node : nodes) {
            allNodes.add(node.val);
        }
        return lowestCommonAncestor(root);
    }

    TreeNode lowestCommonAncestor(TreeNode root) {
        if (root==null) return null;
        if (allNodes.contains(root.val)) return root;

        TreeNode left=lowestCommonAncestor(root.left);
        TreeNode right=lowestCommonAncestor(root.right);

        if (left==null) return right;
        else if (right==null) return left;
        else return root;
    }
}
