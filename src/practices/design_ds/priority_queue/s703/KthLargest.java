package practices.design_ds.priority_queue.s703;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>();
        this.k=k;
        for (int num : nums) add(num);
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size()>k) pq.poll();
        return pq.peek();
    }
}
