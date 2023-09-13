package practices.design_ds.priority_queue.s451;

import practices.binary_tree.TreeNode;

import java.util.HashMap;

public class Solution {
    private HashMap<Integer, Integer> levelToStart=new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        return maxWidth(root, 1, 1);
    }

    private int maxWidth(TreeNode root, int depth, int index) {
        if (root==null) return 0;

        levelToStart.putIfAbsent(depth, index);
        int leftWidth=maxWidth(root.left, depth+1, index*2);
        int rightWidth=maxWidth(root.right, depth+1, index*2+1);
        int maxWidth=Math.max(leftWidth, rightWidth);

        return Math.max(index-levelToStart.get(depth)+1, maxWidth);
    }
}
