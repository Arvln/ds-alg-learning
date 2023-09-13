package practices.binary_tree.s1120;

import practices.binary_tree.TreeNode;

public class Solution {
    public double maximumAverageSubtree(TreeNode root) {
        return maximumAverage(root, 0, 0);
    }

    double maximumAverage(TreeNode root, int sum, int count) {
        if (root==null) return 0;

        double left=maximumAverage(root.left, sum, count);
        double right=maximumAverage(root.right, sum, count);

        sum+=root.val;
        count++;

        return Math.max( sum*1.0/count, Math.max(left, right));
    }
}
