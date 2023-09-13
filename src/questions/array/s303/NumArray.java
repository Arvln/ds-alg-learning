package questions.array.s303;

public class NumArray {
    private int[] prevSum;

    public NumArray(int[] nums) {
        prevSum = new int[nums.length+1];

        for (int i = 1; i < prevSum.length; i++) {
            prevSum[i] = prevSum[i-1]+nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return prevSum[right+1]-prevSum[left];
    }
}
