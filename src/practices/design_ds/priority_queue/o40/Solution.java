package practices.design_ds.priority_queue.o40;

import java.util.PriorityQueue;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->b.compareTo(a));

        for (int i=0; i<arr.length; i++) {
            pq.offer(arr[i]);
            if (pq.size()>k) pq.poll();
        }

        int[] res=new int[k];
        for(int i=0; i<res.length&&!pq.isEmpty(); i++) {
            res[i]=pq.poll();
        }

        return res;
    }
}
