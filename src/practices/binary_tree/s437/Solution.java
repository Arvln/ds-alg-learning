package practices.binary_tree.s437;

import practices.binary_tree.TreeNode;

public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root==null) return 0;
        int curSum=sum(root, targetSum);

        curSum+=pathSum(root.left, targetSum);
        curSum+=pathSum(root.right, targetSum);
        return curSum;
    }

    int sum(TreeNode root, long targetSum) {
        int res=0;
        if (root==null) return 0;
        if (root.val==targetSum) res++;

        res+=sum(root.left, targetSum-root.val);
        res+=sum(root.right, targetSum-root.val);

        return res;
    }
}
