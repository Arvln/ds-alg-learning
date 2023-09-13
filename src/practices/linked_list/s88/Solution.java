package practices.linked_list.s88;

import java.util.PriorityQueue;

public class Solution {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            pq.offer(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            pq.offer(nums2[i]);
        }

        int k=m+n;
        while (!pq.isEmpty() && k>0) {
            int poll = pq.poll();
            nums1[nums1.length-k]=poll;
            k--;
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, l=nums1.length-1;
        while(i>=0 && j>=0) {
            if (nums1[i]>nums2[j]) {
                nums1[l]=nums1[i];
                i--;
            } else {
                nums1[l]=nums2[j];
                j--;
            }
            l--;
        }
        while(j>=0) {
            nums1[l]=nums2[j];
            j--;
            l--;
        }
    }
}
