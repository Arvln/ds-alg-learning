package practices.binary_tree.s450;

import practices.binary_tree.TreeNode;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) return null;

        if (root.val>key) {
            root.left=deleteNode(root.left, key);
        } else if (root.val<key) {
            root.right=deleteNode(root.right, key);
        } else {
            if (root.left==null) return root.right;
            else if (root.right==null) return root.left;
            else {
                TreeNode min=root.right;
                while (min.left!=null) min=min.left;

                min.right=deleteNode(root.right, min.val);
                min.left=root.left;
                return min;
            }
        }

        return root;
    }
}
