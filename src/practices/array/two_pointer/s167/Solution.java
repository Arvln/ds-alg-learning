package practices.array.two_pointer.s167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0, right=numbers.length-1;
        while (left<right) {
            int result=numbers[left]+numbers[right];

            if (result==target) {
                return new int[]{left+1, right+1};
            } else if (result<target) {
                left++;
            } else if (result>target) {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
    /**
     * 数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数下標
     *
     * tips
     * 1, 有序數組可用二分搜索
     *
     * */
}
