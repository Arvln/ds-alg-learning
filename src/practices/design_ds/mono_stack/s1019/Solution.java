package practices.design_ds.mono_stack.s1019;

import practices.linked_list.ListNode;

import java.util.Stack;

public class Solution {
    private int[] res;
    public int[] nextLargerNodes1(ListNode head) {
        traverse(head, new Stack<>(), 0);
        return res;
    }

    private void traverse(ListNode head, Stack<Integer> s, int i) {
        if (head==null) {
            res=new int[i];
            return;
        }

        traverse(head.next, s, i+1);

        while(!s.isEmpty()&&s.peek()<=head.val) s.pop();
        if (!s.isEmpty()) res[i]=s.peek();
        s.push(head.val);
    }

    public int[] nextLargerNodes2(ListNode head) {
        Stack<int[]> s = new Stack<>();
        int n=0;
        for (ListNode p=head; p!=null; p=p.next, n++);
        int[] res = new int[n];
        for (int i = 0; head!=null; head=head.next, i++) {
            while (!s.isEmpty()&&s.peek()[0]<head.val) res[s.pop()[1]]=head.val;
            s.push(new int[]{head.val, i});
        }
        return res;
    }
}
