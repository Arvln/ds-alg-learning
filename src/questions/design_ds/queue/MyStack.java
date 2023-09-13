package questions.design_ds.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> q;
    private int top;

    public MyStack() {
        q=new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);
        top=x;
    }

    public int pop() {
        int size=q.size();

        while (size>2) {
            q.offer(q.poll());
            size--;
        }

        top=q.poll();
        q.offer(top);
        return q.poll();
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
