package practices.array.sliding_window.s1658;

import java.util.Arrays;

public class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        if (sum<x) return -1;

        int left=0, right=0, lSum=0, rSum=sum, count=Integer.MAX_VALUE;
        while (right<nums.length) {
            rSum-=nums[right];
            right++;

            while (lSum+rSum<x) {
                lSum+=nums[left];
                left++;
            }
            if (lSum+rSum==x) count=Integer.min(count, nums.length-right+left);
        }

        return count==Integer.MAX_VALUE ? -1 : count;
    }
    /**
     *  每一次操作时，你应当移除数组最左边或最右边的元素，然后从 x 中减去该元素的值。
     *  如果可以将 x恰好 减到0 ，返回 最小操作数 ；否则，返回 -1
     *
     * tips
     * 1, 右移左界時機需要比較的左邊之和+右邊之和的值是否小於x
     * 2, 難點在於左邊和及右邊和的計算，右邊和為數組總和-當前右界元素、左邊和為0+當前左界元素
     * 3, 右移右界時減小右邊和大小，右移左界時增加左邊和大小逼近結果
     * 4, 每次檢查並更新結果
     *
     * */
}
