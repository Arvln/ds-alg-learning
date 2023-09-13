package questions.binary_tree.s116;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect1(Node root) {
        if (root==null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node cur=queue.poll();

                if (i<size-1) {
                    cur.next=queue.peek();
                }
                if(cur.left!=null) {
                    queue.offer(cur.left);
                }
                if(cur.right!=null) {
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }

    public Node connect2(Node root) {
        if (root==null) return null;
        traverse(root.left, root.right);
        return root;
    }

    void traverse(Node n1, Node n2) {
        if (n1==null || n2==null) return;

        n1.next=n2;
        traverse(n1.left, n1.right);
        traverse(n2.left, n2.right);
        traverse(n1.right, n2.left);
    }
}
