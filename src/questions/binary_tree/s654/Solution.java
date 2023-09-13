package questions.binary_tree.s654;

public class Solution {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }

    TreeNode build(int[] nums, int start, int end) {
        if (start>=end) return null;

        int index=0, maxVal=Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (nums[i]>maxVal) {
                maxVal=nums[i];
                index=i;
            }
        }

        TreeNode cur=new TreeNode(maxVal);
        cur.left=build(nums, start, index);
        cur.right=build(nums, index+1, end);
        return cur;
    }
}
