package practices.array.sliding_window.s220;

import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();
        int left=0, right=0;
        while (right<nums.length) {
            Long ceiling = set.ceiling((long) nums[right] - (long) valueDiff);

            if (ceiling!=null && ceiling<= (long)nums[right] + (long) valueDiff) {
                return true;
            }
            set.add((long) nums[right]);
            right++;

            if (right-left>indexDiff) {
                set.remove((long) nums[left]);
                left++;
            }
        }

        return false;
    }
    /**
     *  找出满足下述条件的下标对 (i, j)：
     *  - i != j,
     *  - abs(i - j) <= indexDiff
     *  - abs(nums[i] - nums[j]) <= valueDiff
     *
     * tips
     * 1, 難點在於理解題意，abs(i-j)代表窗口大小的限制，abs(nums[i]-nums[j])<=valueDiff影響結果判斷
     * 2, 根據題意窗口大小>indexDiff時需要右移左界
     * 3, 需要比較窗口內的值則需要對窗口內的值排序，低標是使用TreeSet
     * 4, 每次取出窗口內元素中大於當前元素-valueDiff的最小值，並比較是否小於當前元素+valueDiff
     * 5, 當前元素+valueDiff在兩正整數間可能溢出需要以Long類型存儲
     *
     * */
}
