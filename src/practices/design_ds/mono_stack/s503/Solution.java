package practices.design_ds.mono_stack.s503;

import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[nums.length];
        for (int i=2*nums.length-1; i>=0; i--) {
            int index=i%nums.length;
            while (!stack.isEmpty()&&stack.peek()<=nums[index]) stack.pop();
            res[index]=stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[index]);
        }

        return res;
    }
}
