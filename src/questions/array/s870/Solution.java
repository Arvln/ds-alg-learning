package questions.array.s870;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];
        PriorityQueue<int []> maxPQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < nums2.length; i++) {
            maxPQ.offer(new int[]{nums2[i], i});
        }

        Arrays.sort(nums1);
        int min=0, max=n-1;

        while (!maxPQ.isEmpty()) {
            int[] poll = maxPQ.poll();
            int maxVal = poll[0];
            int i = poll[1];

            if (nums1[max]>maxVal) {
                result[i] = nums1[max];
                max--;
            } else {
                result[i] = nums1[min];
                min++;
            }
        }

        return result;
    }
}
