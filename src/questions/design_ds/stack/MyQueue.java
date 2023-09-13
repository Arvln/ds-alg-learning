package questions.design_ds.stack;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> head, tail;

    public MyQueue() {
        head=new Stack<>();
        tail=new Stack<>();
    }

    public void push(int x) {
        tail.push(x);
    }

    public int pop() {
        peek();
        return head.pop();
    }

    public int peek() {
        if (head.isEmpty()) {
            while (!tail.isEmpty()) head.push(tail.pop());
        }
        return head.peek();
    }

    public boolean empty() {
        return head.isEmpty()&&tail.isEmpty();
    }
}
