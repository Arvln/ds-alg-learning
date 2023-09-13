package questions.array.s15;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        int left = start, right = nums.length - 1;
        while (left < right) {
            int low = nums[left];
            int height = nums[right];
            int sum = low + height;

            if (sum == target) {
                List<Integer> tuple = new ArrayList<>();
                tuple.add(low);
                tuple.add(height);
                result.add(tuple);
                while (left < right && nums[left] == low) left++;
                while (left < right && nums[right] == height) right--;
            } else if (sum < target) {
                while (left < right && nums[left] == low) left++;
            } else if (sum > target) {
                while (left < right && nums[right] == height) right--;
            }
        }

        return result;
    }

    private static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tuples = twoSum(nums,  i+1,target - nums[i]);

            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                result.add(tuple);
            }
            while (i < nums.length - 1 && nums[i] == nums[i+1]) i++;
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);
    }
}
