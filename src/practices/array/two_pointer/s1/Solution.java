package practices.array.two_pointer.s1;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
    /**
     * 在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标
     *
     * tips
     * 1, hashmap紀錄值與下標並找出和與其互補的數
     *
     * */
}
