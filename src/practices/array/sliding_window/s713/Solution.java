package practices.array.sliding_window.s713;

public class Solution {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left=0, right=0, product=1, count=0;
        while (right<nums.length) {
            product*=nums[right];
            right++;

            while (left<right && product>=k) {
                product/=nums[left];
                left++;
            }

            count+=right-left;
        }

        return count;
    }
    /**
     *  返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目
     *
     * tips
     * 1, 難點在於計算結果
     * 2, 子數組的數目等於窗口大小加總
     *
     * */
}
