package questions.array.s316;

import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[256];
        int[] count = new int[256];
        for (int i=0; i<s.length(); i++) count[s.charAt(i)]++;

        for (char c : s.toCharArray()) {
            count[c]--;
            if (inStack[c]) continue;

            while (!stack.empty() && stack.peek()>c && count[stack.peek()]>0)
                inStack[stack.pop()]=false;

            stack.push(c);
            inStack[c]=true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }
}
