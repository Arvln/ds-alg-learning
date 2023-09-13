package practices.linked_list.s977;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int i=0, j=nums.length-1, l=j;
        int[] res = new int[nums.length];
        while(i<=j) {
            int left=nums[i]*nums[i], right=nums[j]*nums[j];
            if (left>right) {
                res[l]=left;
                i++;
            } else {
                res[l]=right;
                j--;
            }
            l--;
        }
        return res;
    }
}
