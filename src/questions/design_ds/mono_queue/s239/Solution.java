package questions.design_ds.mono_queue.s239;

import java.util.LinkedList;

class MonotonicQueue {
    private LinkedList<Integer> q=new LinkedList<>();

    public void push(int n) {
        while (!q.isEmpty()&&q.getLast()<n) q.pollLast();
        q.addLast(n);
    }

    public int max() { return q.getFirst(); }

    public void pop(int n) {
        if (n==max()) q.pollFirst();
    }
}

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue mq = new MonotonicQueue();
        int[] res=new int[nums.length-k+1];

        int left=0, right=0;
        while (right<nums.length) {
            mq.push(nums[right]);
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
