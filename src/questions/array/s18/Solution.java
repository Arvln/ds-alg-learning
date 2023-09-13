package questions.array.s18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private static List<List<Integer>> twoSum(int[] nums, int start, long target) {
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

    private static List<List<Integer>> nSum(int[] nums, int n, int start, long target) {
        List<List<Integer>> result = new ArrayList<>();

        if (n < 2 || nums.length < n) return result;
        else if (n == 2) return twoSum(nums, start, target);
        else {
            Arrays.sort(nums);
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> tuples = nSum(nums,  n-1 ,i+1,target - nums[i]);

                for (List<Integer> tuple : tuples) {
                    tuple.add(nums[i]);
                    result.add(tuple);
                }
                while (i < nums.length - 1 && nums[i] == nums[i+1]) i++;
            }

            return result;
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        return nSum(nums, 4, 0, target);
    }
}
