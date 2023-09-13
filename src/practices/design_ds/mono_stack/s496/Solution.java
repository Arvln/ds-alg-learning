package practices.design_ds.mono_stack.s496;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer, Integer> valToNextGreater=new HashMap<>();
        for (int i=nums2.length-1; i>=0; i--) {
            while(!stack.isEmpty()&&stack.peek()<=nums2[i]) stack.pop();
            valToNextGreater.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        int[] res=new int[nums1.length];
        for (int i=0; i<res.length; i++) {
            res[i]=valToNextGreater.get(nums1[i]);
        }

        return res;
    }
}
