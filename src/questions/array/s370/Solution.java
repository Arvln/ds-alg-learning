package questions.array.s370;

class Difference {
    private final int[] diff;

    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];

        for (int i = 1; i < diff.length; i++) {
            diff[i] = nums[i] - nums[i-1];
        }
    }

    public void increment(int i, int j, int value) {
        diff[i] += value;

        if (j+1 < diff.length) diff[j+1] -= value;
    }

    public int[] result() {
        int[] result = new int[diff.length];
        result[0] = diff[0];

        for (int i = 1; i < diff.length; i++) {
            result[i] = result[i-1] + diff[i];
        }

        return result;
    }
}

public class Solution {
    static int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        Difference difference = new Difference(nums);

        for (int[] update : updates) {
            difference.increment(update[0]-1, update[1]-1, update[2]);
        }

        return difference.result();
    }
}
