package practices.design_ds.priority_queue.s347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> valToFreq=new HashMap<>();

        for (int n : nums) valToFreq.put(n, valToFreq.getOrDefault(n, 0)+1);

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        for (Map.Entry<Integer, Integer> entry : valToFreq.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size()>k) pq.poll();
        }

        int[] res=new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=pq.poll()[0];
        }
        return res;
    }
}
