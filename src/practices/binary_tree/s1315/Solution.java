package practices.binary_tree.s1315;

import practices.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private Queue<TreeNode> queue=new LinkedList<>();

    public int sumEvenGrandparent1(TreeNode root) {
        traverse1(root);

        int sum=0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();

            if (poll.left!=null) sum+=poll.left.val;
            if (poll.right!=null) sum+=poll.right.val;
        }

        return sum;
    }

    void traverse1(TreeNode root) {
        if (root==null) return;

        if (root.val%2==0) {
            if (root.left!=null) queue.offer(root.left);
            if (root.right!=null) queue.offer(root.right);
        }

        traverse1(root.left);
        traverse1(root.right);
    }

    private int sum=0;
    public int sumEvenGrandparent(TreeNode root) {
        traverse(root, 1, 1);
        return sum;
    }

    void traverse(TreeNode cur, int gpVal, int pVal) {
        if (cur==null) return;

        if (gpVal%2==0) sum+=cur.val;

        traverse(cur.left, pVal, cur.val);
        traverse(cur.right, pVal, cur.val);
    }
}
