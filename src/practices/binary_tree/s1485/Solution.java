package practices.binary_tree.s1485;

import practices.binary_tree.TreeNode;

import java.util.HashMap;

public class Solution {
    private static class Node {
        int val;
        Node left;
        Node right;
        Node random;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right, Node random) {
          this.val = val;
          this.left = left;
          this.right = right;
          this.random = random;
        }
    }

    private static class NodeCopy {
        int val;
        NodeCopy left;
        NodeCopy right;
        NodeCopy random;
        NodeCopy() {}
        NodeCopy(int val) { this.val = val; }
        NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }

    private HashMap<Node, NodeCopy> map=new HashMap<>();
    public NodeCopy copyRandomBinaryTree(Node root) {
        return buildCopy(root);
    }

    NodeCopy buildCopy(Node root) {
        if (root==null) return null;
        if (map.containsKey(root)) return map.get(root);

        NodeCopy copy = new NodeCopy(root.val);
        map.put(root, copy);

        copy.left=buildCopy(root.left);
        copy.right=buildCopy(root.right);
        copy.random=buildCopy(root.random);

        return copy;
    }
}
