package practices.design_ds.mono_queue.o59;

import java.util.LinkedList;

public class MaxQueue {
    private LinkedList<Integer> q, max;

    public MaxQueue() {
        q=new LinkedList<>();
        max=new LinkedList<>();
    }

    public int max_value() {
        if (max.isEmpty()) return -1;
        return max.peekFirst();
    }

    public void push_back(int value) {
        q.offerLast(value);
        while(!max.isEmpty()&&max.peekLast()<value) max.pollLast();
        max.offerLast(value);
    }

    public int pop_front() {
        if (q.isEmpty()) return -1;

        int front=q.pollFirst();
        if (front==max_value()) max.pollFirst();
        return front;
    }
}
