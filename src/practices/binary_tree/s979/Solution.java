package practices.binary_tree.s979;

import practices.binary_tree.TreeNode;

public class Solution {
    private int res=0;
    public int distributeCoins(TreeNode root) {
        traverse(root);
        return res;
    }

    int[] traverse1(TreeNode root) {
        if (root==null) return new int[]{0, 0};

        int[] left=traverse1(root.left);
        int[] right=traverse1(root.right);

        int coins=left[0]+right[0]+root.val;
        int nodes=left[1]+right[1]+1;
        res+=Math.abs(coins-nodes);

        return new int[]{coins, nodes};
    }

    int traverse(TreeNode root) {
        if (root==null) return 0;

        int left=traverse(root.left);
        int right=traverse(root.right);

        int d=left+right+root.val-1;
        res+=Math.abs(d);

        return d;
    }
}
