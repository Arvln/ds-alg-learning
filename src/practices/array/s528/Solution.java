package practices.array.s528;

public class Solution {
    private int[] preSum;

    public Solution(int[] w) {
        preSum=new int[w.length+1];

        for (int i = 1; i < preSum.length; i++) {
            preSum[i]=preSum[i-1]+w[i-1];
        }
    }

    public int pickIndex() {
        int target = (int) (Math.random() * preSum[preSum.length - 1])+1;
        int left=1, right=preSum.length;
        while (left<right) {
            int mid=left+(right-left)/2;

            if (preSum[mid]==target) {
                right=mid;
            } else if (preSum[mid]<target) {
                left=mid+1;
            } else if (preSum[mid]>target) {
                right=mid;
            }
        }
        return left-1;
    }
}
