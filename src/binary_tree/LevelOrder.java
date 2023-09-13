package binary_tree;

import queue.LinkedListQueue;

public class LevelOrder {
    private static void levelOrder(TreeNode root) {
        if (root == null) return;

        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int row = 1;

        while (!queue.isEmpty()) {
            int nextSize = 0;

            for (int i = 0; i < row; i++) {
                TreeNode top = queue.poll();
                System.out.print(top);
                if (top.left != null) {
                    queue.offer(top.left);
                    nextSize++;
                }
                if (top.right != null) {
                    queue.offer(top.right);
                    nextSize++;
                }
            }
            System.out.println();
            row = nextSize;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(
                                new TreeNode(8),
                                4,
                                new TreeNode(9)
                        ),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );

        levelOrder(root);
    }
}
