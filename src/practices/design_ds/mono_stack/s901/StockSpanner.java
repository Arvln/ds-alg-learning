package practices.design_ds.mono_stack.s901;

import java.util.Stack;

public class StockSpanner {
    private Stack<int[]> s;
    private int day;
    public StockSpanner() {
        s=new Stack<>();
        s.push(new int[]{Integer.MAX_VALUE, 0});
        day=0;
    }

    public int next(int price) {
        day++;
        while (!s.isEmpty()&&s.peek()[0]<=price) s.pop();
        int res=day-s.peek()[1];
        s.push(new int[]{price, day});
        return res;
    }
}
