package practices.array.sliding_window.s1004;

public class Solution {
    public int longestOnes1(int[] nums, int k) {
        int left=0, right=0, max=0;
        while (right<nums.length) {
            if (nums[right]==0) k--;

            right++;

            while (k<0) {
                if (nums[left]==0) k++;
                left++;
            }

            max = Integer.max(max, right-left);
        }

        return max;
    }

    public static int longestOnes(int[] nums, int k) {
        int left=0, right=0, max1=0, count1=0;
        while (right<nums.length) {
            count1+=nums[right];
            max1=Integer.max(max1, count1);
            right++;

            if (right-left-max1>k) {
                count1-=nums[left];
                left++;
            }
        }

        return right-left;
    }
    /**
     *  翻转最多 k 个 _ ，则返回 数组中连续 _ 的最大个数
     *
     * tips
     * 1, 難點在右移左界時機
     * 2, 答案長度跟[left..right)內同一字符歷史天量有關，同一字符歷史天量越大結果越多
     * 3, 右移左界時機在窗口大小減去同一字符歷史天量大於k時
     * 4, 最後窗口大小為(同一字符歷史天量+k或歷史天量)即為結果
     *
     * */
}
