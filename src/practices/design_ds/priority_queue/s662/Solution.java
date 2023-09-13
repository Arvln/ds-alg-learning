package practices.design_ds.priority_queue.s662;

import practices.binary_tree.TreeNode;

import java.util.HashMap;

public class Solution {
    private HashMap<Integer, Integer> levelToLeftest=new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        return maxWidth(root, 1, 1);
    }

    private int maxWidth(TreeNode root, int index, int depth) {
        if (root==null) return 0;

        levelToLeftest.putIfAbsent(depth, index);
        int leftMaxWidth=maxWidth(root.left, index*2, depth+1);
        int rightMaxWidth=maxWidth(root.right, index*2+1, depth+1);
        int maxWidth=Math.max(leftMaxWidth, rightMaxWidth);

        return Math.max(index-levelToLeftest.get(depth)+1, maxWidth);
    }
}
