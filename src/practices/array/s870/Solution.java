package practices.array.s870;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> maxPQ = new PriorityQueue<>((a, b) -> b[1]-a[1]);

        for (int i = 0; i < nums2.length; i++) {
            maxPQ.offer(new int[]{i, nums2[i]});
        }

        Arrays.sort(nums1);
        int[] res = new int[nums1.length];
        int left=0, right=nums1.length-1;
        while (!maxPQ.isEmpty()) {
            int[] poll = maxPQ.poll();
            int i=poll[0], maxVal=poll[1];

            if (nums1[right]>maxVal) {
                res[i]=nums1[right];
                right--;
            } else {
                res[i]=nums1[left];
                left++;
            }
        }
        return res;
    }
}
