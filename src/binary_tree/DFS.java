package binary_tree;

import stack.LinkedListStack;

public class DFS {
    /**
     *
     * preOrder 1, 2, 4, 7, 3, 5, 6
     * inOrder 4, 2, 7, 1, 5, 3, 6
     * postOrder 4, 7, 2, 5, 6, 3, 1
     */
    private static void preOrder1(TreeNode current) {
        if (current == null) return;

        System.out.print(current + " ");
        preOrder1(current.left);
        preOrder1(current.right);
    }

    private static void inOrder1(TreeNode current) {
        if (current == null) return;

        inOrder1(current.left);
        System.out.print(current + " ");
        inOrder1(current.right);
    }

    private static void postOrder1(TreeNode current) {
        if (current == null) return;

        postOrder1(current.left);
        postOrder1(current.right);
        System.out.print(current + " ");
    }

    private static void order(TreeNode current) {
        LinkedListStack<TreeNode> stack = new LinkedListStack<>();
        TreeNode lastPop = null;

        while (current != null || !stack.isEmpty()) {
            if (current == null) {
                TreeNode prev = stack.peak();

                if (prev.right == null) {
                    // System.out.println("in: " + prev.value);
                    lastPop = stack.pop();
                    // System.out.println("post: " + prev.value);
                } else if (prev.right == lastPop) {
                    lastPop = stack.pop();
                    // System.out.println("post: " + prev.value);
                } else {
                    // System.out.println("in: " + prev.value);
                    current = prev.right;
                }
            } else {
                // System.out.println("pre: " + current.value);
                stack.push(current);
                current = current.left;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(7)),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        order(root);
    }
}
