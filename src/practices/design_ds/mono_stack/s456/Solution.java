package practices.design_ds.mono_stack.s456;

import java.util.Stack;

public class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        int k = Integer.MIN_VALUE;
        for (int i=n-1; i>=0; i--) {
            if (nums[i]<k) return true;
            while (!s.isEmpty()&&s.peek()<nums[i]) k=s.pop();
            s.push(nums[i]);
        }
        return false;
    }
}
