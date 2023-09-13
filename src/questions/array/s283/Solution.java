package questions.array.s283;

public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) return;

        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }
}
