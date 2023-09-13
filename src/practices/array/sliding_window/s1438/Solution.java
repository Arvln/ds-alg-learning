package practices.array.sliding_window.s1438;

import java.util.TreeMap;

public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left=0 ,right=0, max=0;
        while (right<nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            right++;

            while (map.lastKey()-map.firstKey()>limit) {
                map.put(nums[left], map.get(nums[left])-1);
                if (map.get(nums[left])==0) map.remove(nums[left]);
                left++;
            }
            max=Integer.max(max, right-left);
        }

        return max;
    }
    /**
     *  返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit
     *
     * tips
     * 1, 右移左界時機需要比較[left..right)內的值，本題是最大值-最小值>limit
     * 2, 難點在於不同值的判斷
     * 3, TreeMap是紅黑樹，樹的key是有序的，可統計窗口內數字及對應個數並取出最大及最小數字
     * 4, 右移左界時續檢查數字個數，為0則需刪除key
     * 5, 每次檢查窗口大小更新結果
     *
     * */
}
