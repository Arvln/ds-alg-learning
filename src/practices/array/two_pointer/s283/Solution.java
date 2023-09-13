package practices.array.two_pointer.s283;

public class Solution {
    public void moveZeroes(int[] nums) {
        int slow=0, fast=0;
        while (fast<nums.length) {
            if (nums[fast]!=0) {
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow<nums.length) {
            nums[slow]=0;
            slow++;
        }
    }
    /**
     * 编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
     *
     * tips
     * 同26
     *
     * */
}
