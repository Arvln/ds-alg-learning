package practices.array.prev_sum.s303;

import java.util.Arrays;

public class NumArray {
    private static int[] preSum;

    public NumArray(int[] nums) {
        preSum=new int[nums.length+1];

        for (int i = 1; i < preSum.length; i++) {
            preSum[i]=preSum[i-1]+nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right+1]-preSum[left];
    }

    public int[] useArray() {
        int[] array = new int[preSum.length-1];

        for (int i = 0; i < array.length; i++) {
            array[i]=preSum[i+1]-preSum[i];
        }

        return array;
    }
}
