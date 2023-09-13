package practices.binary_tree.s549;

import practices.binary_tree.TreeNode;

public class Solution {
    public static int longestConsecutive(TreeNode root) {
        if (root==null) return 0;

        int length=length(root, null)+1;

        return Math.max(length, Math.max(longestConsecutive(root.left), longestConsecutive(root.right)));
    }

    static int length(TreeNode root, TreeNode parent) {
        int res=0;

        if (root==null) return res;

        if (parent!=null&&Math.abs(parent.val-root.val)==1) res++;

        res+=length(root.left, root);
        res+=length(root.right, root);

        return res;
    }
}
