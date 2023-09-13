package practices.binary_tree.s988;

import practices.binary_tree.TreeNode;

public class Solution {
    private String res;
    public String smallestFromLeaf(TreeNode root) {
        traverse(root, "");
        return res;
    }

    void traverse(TreeNode root, String s) {
        if (root==null) return;

        s = (char)('a'+root.val)+s;

        if (root.left==null&&root.right==null) {
            if (res==null||s.compareTo(res)<0) res=s;
        }

        traverse(root.left, s);
        traverse(root.right, s);
    }
}
