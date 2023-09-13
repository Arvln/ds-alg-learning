package practices.design_ds.mono_queue.s239;

import java.util.LinkedList;

class MonoQueue {
    private LinkedList<Integer> q=new LinkedList<>();

    public void offer(int x) {
        while (!q.isEmpty()&&q.getLast()<x) q.pollLast();
        q.addLast(x);
    }

    public int max() {
        return q.getFirst();
    }

    public void pop(int x) {
        if (x==max()) q.pollFirst();
    }
}

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonoQueue mq=new MonoQueue();
        int[] res=new int[nums.length-k+1];
        int left=0, right=0;
        while (right<nums.length) {
            mq.offer(nums[right]);
            right++;

            if (right-left==k) {
                res[left]=mq.max();
                mq.pop(nums[left]);
                left++;
            }
        }

        return res;
    }
}
