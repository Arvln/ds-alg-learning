package practices.array.two_pointer.o21;

public class Solution {
    public static int[] exchange(int[] nums) {
        int slow=0, fast=0;
        while (fast< nums.length) {
            if (nums[fast]%2==1) {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}
