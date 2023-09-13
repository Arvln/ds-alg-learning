package practices.binary_tree.s1430;

import practices.binary_tree.TreeNode;

public class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root==null) return false;
        return isValid(root, arr, 0);
    }

    boolean isValid(TreeNode root, int[] arr, int index) {
        if (index==arr.length-1&&root.left==null&&root.right==null&&root.val==arr[index]) return true;
        if (root==null) return false;
        if (root.val!=arr[index]) return false;

        return isValid(root.left, arr, index+1)||isValid(root.right, arr, index+1);
    }
}
