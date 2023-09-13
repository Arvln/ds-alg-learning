package practices.binary_tree.s606;

import practices.binary_tree.TreeNode;

public class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, 0, sb);
        return sb.toString();
    }

    void traverse(TreeNode root, int depth, StringBuilder sb) {
        if (root==null) return;

        if (depth>0) sb.append("(");
        sb.append(root.val);

        traverse(root.left, depth+1, sb);

        if (root.left==null&&root.right!=null) sb.append("()");

        traverse(root.right, depth+1, sb);

        if (depth>0) sb.append(")");
    }
}
