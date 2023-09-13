package practices.binary_tree.s1372;

import practices.binary_tree.TreeNode;

public class Solution {
    private int max=0;
    public int longestZigZag(TreeNode root) {
        maxPath(root, null);
        return max;
    }

    int maxPath(TreeNode root, TreeNode parent) {
        if (root==null) return 0;

        int left=maxPath(root.left, root);
        int right=maxPath(root.right, root);

        max=Math.max(max, Math.max(left, right));

        if (parent!=null&&root==parent.left) return right+1;
        else if (parent!=null&&root==parent.right) return left+1;
        else return 0;
    }
}
