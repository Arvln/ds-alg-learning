package practices.binary_tree.s513;

import practices.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int deepestLeft=0;
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size=queue.size();
            deepestLeft=queue.peek().val;

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                if (poll.left!=null) queue.offer(poll.left);
                if (poll.right!=null) queue.offer(poll.right);
            }
        }

        return deepestLeft;
    }
}
