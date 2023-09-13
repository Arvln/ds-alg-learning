package questions.array.s1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {
    public int[] fastTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }

    private static class Pair {
        int value, index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Pair[] array = new Pair[nums.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Pair(nums[i], i);
        }
        Arrays.sort(array, Comparator.comparing(item -> item.value));

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int result = array[left].value + array[right].value;

            if (result == target) {
                return new int[]{array[left].index, array[right].index};
            } else if (result > target) {
                right--;
            } else if (result < target) {
                left++;
            }
        }
        return null;
    }
}
