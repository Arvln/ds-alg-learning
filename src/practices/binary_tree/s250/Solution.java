package practices.binary_tree.s250;

import practices.binary_tree.TreeNode;

public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        return sum(root);
    }

    int sum(TreeNode root) {
        if (root==null) return 0;

        int leftSum=sum(root.left);
        int rightSum=sum(root.right);

        if (root.left==null&&root.right==null) return 1;
        if (root.left==null&&root.right.val==root.val) return rightSum+1;
        if (root.right==null&&root.left.val==root.val) return leftSum+1;
        if (root.left!=null&&root.right!=null) {
            if (root.val==root.left.val&&root.val==root.right.val) return leftSum+rightSum+1;
        }

        return 0;
    }
}
