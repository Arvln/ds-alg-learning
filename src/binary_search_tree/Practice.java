package binary_search_tree;

import stack.LinkedListStack;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    public static boolean isValidBST1(TreeNode node) {
        TreeNode current = node;
        LinkedListStack<TreeNode> stack = new LinkedListStack<>();
        TreeNode prev = null;

        while (current != null || !stack.isEmpty()) {
            if (current == null) {
                TreeNode top = stack.pop();

                if (prev != null && prev.value >= top.value) {
                    return false;
                }
                prev = top;

                current = top.right;
            } else {
                stack.push(current);
                current = current.left;
            }
        }

        return true;
    }

    private static long prev = Long.MIN_VALUE;

    public static boolean isValidBST2(TreeNode node) {
        if (node == null) return true;

        boolean isLeftTreeValid = isValidBST2(node.left);

        if (!isLeftTreeValid) return false;
        if (prev > node.value) return false;

        prev = node.value;

        return isValidBST2(node.right);
    }

    private static boolean isValidBST3Helper(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.value <= min || node.value >= max) return false;

        return isValidBST3Helper(node.left, min, node.value) && isValidBST3Helper(node.right, node.value, max);
    }

    public static boolean isValidBST3(TreeNode node) {
        return isValidBST3Helper(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public int rangeSum1(TreeNode node, int start, int end) {
        TreeNode current = node;
        LinkedListStack<TreeNode> stack = new LinkedListStack<>();
        int result = 0;

        while (current != null || !stack.isEmpty()) {
            if (current == null) {
                TreeNode prev = stack.pop();

                if (prev.value > end) break;
                if (prev.value >= start) {
                    result += prev.value;
                }

                current = prev.right;
            } else {
                stack.push(current);
                current = current.left;
            }
        }

        return result;
    }

    public int rangeSum2(TreeNode node, int start, int end) {
        if (node == null) return 0;
        if (node.value < start) {
            return rangeSum2(node.right, start, end);
        }
        if (node.value > end) {
            return rangeSum2(node.left, start, end);
        }

        return node.value + rangeSum2(node.left, start, end) + rangeSum2(node.right, start, end);
    }

    public static TreeNode bstFromPreOrder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        int i = 1;

        while (i < preorder.length) {
            TreeNode current = root;
            TreeNode parent = current;
            int currentValue = preorder[i];

            while (current != null) {
                if (currentValue < current.value) {
                    parent = current;
                    current = current.left;
                } else {
                    parent = current;
                    current = current.right;
                }
            }

            TreeNode newNode = new TreeNode(currentValue);

            if (currentValue < parent.value) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }

            i++;
        }

        return root;
    }
}
