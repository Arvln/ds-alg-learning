package practices.binary_tree.s1602;

import practices.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root==null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                if (poll.val==u.val) {
                    return i<size-1 ? queue.peek() : null;
                }

                if (poll.left!=null) queue.offer(poll.left);
                if (poll.right!=null) queue.offer(poll.right);
            }
        }

        return null;
    }
}
