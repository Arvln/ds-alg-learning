package practices.design_ds.mono_stack.s1475;

import java.util.Stack;

public class Solution {
    public int[] finalPrices(int[] prices) {
        int[] res=new int[prices.length];
        Stack<Integer> s=new Stack<>();
        for (int i=prices.length-1; i>=0; i--) {
            while(!s.isEmpty()&&prices[s.peek()]>prices[i]) s.pop();
            res[i]=s.isEmpty() ? prices[i] : prices[i]-prices[s.peek()];
            s.push(i);
        }

        return res;
    }
}
