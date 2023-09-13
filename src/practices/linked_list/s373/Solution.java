package practices.linked_list.s373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!pq.isEmpty() && k>0) {
            int[] poll = pq.poll();
            int nextIndex=poll[2]+1;
            if (nextIndex<nums2.length) {
                pq.offer(new int[]{poll[0], nums2[nextIndex], nextIndex});
            }

            List<Integer> pair = new ArrayList<>();
            pair.add(poll[0]);
            pair.add(poll[1]);
            res.add(pair);
            k--;
        }
        return res;
    }
}
