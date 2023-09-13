package practices.binary_tree.s559;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root==null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int depth=0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();

                for (Node child : poll.children) {
                    if (child!=null) queue.offer(child);
                }
            }
            depth++;
        }

        return depth;
    }
}
