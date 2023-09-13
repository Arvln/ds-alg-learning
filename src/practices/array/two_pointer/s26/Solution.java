package practices.array.two_pointer.s26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int slow=0, fast=0;
        while (fast<nums.length) {
            if (nums[slow]!=nums[fast]) {
                slow++;
                nums[slow]=nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
    /**
     * 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次
     * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
     *
     * tips
     * 1, 操作數組且當前值可以判斷結果，使用快慢指針
     * 2, 觀察快指針符合條件時以慢指針做更新
     *
     * */
}
