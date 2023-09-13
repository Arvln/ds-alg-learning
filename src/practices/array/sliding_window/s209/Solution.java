package practices.array.sliding_window.s209;

public class Solution {
    public int minSubArrayLen1(int target, int[] nums) {
        int left=0, right=0, sum=0, result=Integer.MAX_VALUE;
        while (right<nums.length) {
            sum+=nums[right];
            right++;

            while (sum-nums[left]>=target) {
                sum-=nums[left];
                left++;
            }
            if (sum>=target) result=Integer.min(result, right-left);
        }

        return result==Integer.MAX_VALUE ? 0 : result;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int left=0, right=0, result=Integer.MAX_VALUE;
        while (right<nums.length) {
            target-=nums[right];
            right++;

            while (target+nums[left]<=0) {
                target+=nums[left];
                left++;
            }
            if (target<=0) result=Integer.min(result, right-left);
        }

        return result==Integer.MAX_VALUE ? 0 : result;
    }
    /**
     *  找出该数组中满足其和 ≥ target 的长度最小的连续子数组
     *
     * tips
     * 1, 右移左界時機需要比較的[left..right)內的和是否滿足條件
     * 2, 難點在於要求和大於等於target，右移左界需判斷sum-當前左界元素是否大於target否則不可右移
     * 3, 每次檢查並更新結果
     *
     * */
}
