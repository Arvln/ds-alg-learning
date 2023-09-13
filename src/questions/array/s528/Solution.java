package questions.array.s528;

public class Solution {
    int[] prevSum;

    public Solution(int[] w) {
        prevSum = new int[w.length+1];

        for (int i = 1; i < prevSum.length; i++) {
            prevSum[i] = w[i-1] + prevSum[i-1];
        }
    }

    public int pickIndex() {
        // detail: 前綴和的索引0是佔位符，target>0才能避免取出索引為0的佔位符
        int random = (int) (Math.random() * prevSum[prevSum.length-1])+1;

        int left=0, right=prevSum.length;
        while (left<right) {
            int mid = left + (right-left) / 2;

            if (prevSum[mid] == random) {
                right=mid;
            } else if (prevSum[mid] < random) {
                left=mid+1;
            } else if (prevSum[mid] > random) {
                right=mid;
            }
        }

        return left-1; // convert preSum index into w index
    }
}
