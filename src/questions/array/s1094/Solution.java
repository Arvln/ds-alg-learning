package questions.array.s1094;

class Difference {
    private final int[] diff;

    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
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

        for (int i = 1; i < result.length; i++) {
            result[i] = result[i-1] + diff[i];
        }

        return result;
    }
}

public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Difference difference = new Difference(new int[1000+1]);

        for (int[] trip : trips) {
            if (trip[0]>capacity) return false;
            difference.increment(trip[1], trip[2]-1, trip[0]);
        }

        for (int numPassengers : difference.result()) {
            if (numPassengers>capacity) return false;
        }

        return true;
    }
}
