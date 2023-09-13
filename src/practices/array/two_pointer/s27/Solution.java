package practices.array.two_pointer.s27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int slow=0, fast=0;
        while (fast<nums.length) {
            if (nums[fast]!=val) {
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
    /**
     * 你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度
     *
     * tips
     * 同26
     *
     * */
}
