package practices.binary_tree.s426;

public class Solution {
    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node head, prev;
    public Node treeToDoublyList(Node root) {
        if (root==null) return null;

        traverse(root);
        prev.right=head;
        head.left=prev;
        return head;
    }

    void traverse(Node root) {
        if (root==null) return;

        traverse(root.left);
        if (prev!=null) {
            prev.right=root;
            root.left=prev;
        } else {
            head=root;
        }
        prev=root;
        traverse(root.right);
    }
}
