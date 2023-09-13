package practices.binary_tree.s563;

import practices.binary_tree.TreeNode;

public class Solution {
    private int res=0;
    public int findTilt(TreeNode root) {
        subTreeSum(root);
        return res;
    }

    int subTreeSum(TreeNode root) {
        if (root==null) return 0;

        int leftSum=subTreeSum(root.left);
        int rightSum=subTreeSum(root.right);

        res+=Math.abs(leftSum-rightSum);

        return root.val+leftSum+rightSum;
    }
}
