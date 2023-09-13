package practices.binary_tree.s654;

import practices.binary_tree.TreeNode;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    TreeNode build(int[] nums, int start, int end) {
        if (start>end) return null;

        int val=nums[start], index=start;
        for (int i = start; i <= end; i++) {
            if (nums[i]>val) {
                val=nums[i];
                index=i;
            }
        }

        TreeNode cur=new TreeNode(val);
        cur.left=build(nums, start, index-1);
        cur.right=build(nums, index+1, end);
        return cur;
    }
}
