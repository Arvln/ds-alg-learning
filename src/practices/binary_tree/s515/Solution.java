package practices.binary_tree.s515;

import practices.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    private List<Integer> res=new LinkedList<>();
    public List<Integer> largestValues(TreeNode root) {
        if (root==null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size(), max=queue.peek().val;

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                max=Math.max(max, poll.val);

                if (poll.left!=null) queue.offer(poll.left);
                if (poll.right!=null) queue.offer(poll.right);
            }
            res.add(max);
        }

        return res;
    }
}
