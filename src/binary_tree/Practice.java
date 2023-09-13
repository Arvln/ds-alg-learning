package binary_tree;

import queue.LinkedListQueue;
import stack.LinkedListStack;

public class Practice {
    private static boolean symmetryTreeHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (right == null || left == null) return false;
        if (left.val != right.val) return false;

        return symmetryTreeHelper(left.left, right.right) && symmetryTreeHelper(left.right, right.left);
    }

    public static boolean isSymmetryTree(TreeNode current) {
        if (current == null) return false;

        return symmetryTreeHelper(current.left, current.right);
    }

    private static int maxDepth1Helper(TreeNode node, int depth) {
        if (node == null) return depth;

        int leftDepth = maxDepth1Helper(node.left, depth + 1);
        int rightDepth = maxDepth1Helper(node.right, depth + 1);

        return Math.max(leftDepth, rightDepth);
    }

    public static int maxDepth1(TreeNode node) {
        return maxDepth1Helper(node, 0);
    }

    public static int maxDepth2(TreeNode current) {
        int max = 0;
        if (current == null) return max;

        LinkedListStack<TreeNode> stack = new LinkedListStack<>();
        TreeNode lastPop = null;

        while (current != null || !stack.isEmpty()) {
            if (current == null) {
                TreeNode prev = stack.peak();

                if (prev.right == null) {
                    lastPop = stack.pop();
                } else if (prev.right == lastPop) {
                    lastPop = stack.pop();
                } else {
                    current = prev.right;
                }
            } else {
                stack.push(current);
                int size = stack.size();
                if (size > max) max = size;
                current = current.left;
            }
        }
        return max;
    }

    public static int maxDepth3(TreeNode node) {
        int depth = 0;
        if (node == null) return depth;

        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();

                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static int minDepth(TreeNode node) {
        int depth = 0;
        if (node == null) return depth;

        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();

            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();

                if (top.left == null && top.right == null) return depth;
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
        }
        return depth;
    }
}
