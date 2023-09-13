package practices.binary_tree.s333;

import practices.binary_tree.TreeNode;

public class Solution {
    private int maxCount=0;
    public int largestBSTSubtree(TreeNode root) {
        subBST(root);
        return maxCount;
    }

    int[] subBST(TreeNode root) {
        if (root==null) return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] left=subBST(root.left);
        int[] right=subBST(root.right);

        int[] res=new int[4];

        if (left[0]==1&&right[0]==1&&root.val>left[2]&&root.val<right[1]) {
            res[0]=1;
            res[1]=Math.min(root.val, left[1]);
            res[2]=Math.max(root.val, right[2]);
            res[3]=left[3]+right[3]+1;

            maxCount=Math.max(maxCount, res[3]);
        } else {
            res[0]=0;
        }

        return res;
    }
}
