package practices.design_ds.mono_stack.s402;

import java.util.Stack;

public class Solution {
    public static String removeKdigits(String num, int k) {
        Stack<Character> s=new Stack<>();
        StringBuilder sb=new StringBuilder();

        for (int i=0; i<num.length(); i++) {
            char val=num.charAt(i);
            while(!s.isEmpty()&&k>0&&s.peek()>val) {
                s.pop();
                k--;
            }
            if (s.isEmpty()&&val=='0') continue;
            s.push(val);
        }
        while (k>0&&!s.isEmpty()) {
            s.pop();
            k--;
        }
        if (s.isEmpty()) s.push('0');

        while (!s.isEmpty()) sb.insert(0, s.pop());

        return sb.toString();
    }
}
