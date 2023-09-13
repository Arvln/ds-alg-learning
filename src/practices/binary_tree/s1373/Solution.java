package practices.binary_tree.s1373;

import practices.binary_tree.TreeNode;

public class Solution {
    private int maxSum=0;
    public int maxSumBST(TreeNode root) {
        subBSTSum(root);
        return maxSum;
    }

    int[] subBSTSum(TreeNode root) {
        if (root==null) return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] left=subBSTSum(root.left);
        int[] right=subBSTSum(root.right);

        int[] res=new int[4];

        if (left[0]==1&&right[0]==1&&root.val>left[2]&&root.val<right[1]) {
            res[0]=1;
            res[1]=Math.min(root.val, left[1]);
            res[2]=Math.max(root.val, right[2]);
            res[3]=root.val+left[3]+right[3];

            maxSum=Math.max(maxSum, res[3]);
        } else {
            res[0]=0;
        }

        return res;
    }
}
