package practices.array.sliding_window.s219;

import java.util.HashSet;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();

        int left=0, right=0;
        while (right<nums.length) {
            if (window.contains(nums[right])) return true;
            window.add(nums[right]);
            right++;

            while (right-left>k) {
                window.remove(nums[left]);
                left++;
            }
        }

        return false;
    }
    /**
     *  判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
     *
     * tips
     * 1, 難點在於理解題意，abs(i - j)代表窗口大小的限制，nums[i] == nums[j]影響結果判斷
     * 2, 根據題意窗口大小>k時需要右移左界，值之間是否相等需要暫存窗口內的值，可以滿足的低標是HashSet
     * 3, 每次檢查當前值是否存在HashSet中
     *
     * */
}
