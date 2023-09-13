package questions.design_ds.mono_stack.s496;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greater=nextGreaterElement(nums2);
        HashMap<Integer, Integer> valToGreater=new HashMap<>();

        for (int i=0; i<nums2.length; i++) {
            valToGreater.put(nums2[i], greater[i]);
        }

        int[] res=new int[nums1.length];
        for (int i=0; i<nums1.length; i++) {
            res[i]=valToGreater.get(nums1[i]);
        }
        return res;
    }

    private int[] nextGreaterElement(int[] nums) {
        int[] res=new int[nums.length];
        Stack<Integer> s=new Stack<>();

        for (int i=nums.length-1; i>=0; i--) {
            while (!s.isEmpty()&&s.peek()<=nums[i]) s.pop();

            res[i]=s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }
}
