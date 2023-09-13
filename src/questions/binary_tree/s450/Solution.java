package questions.binary_tree.s450;

public class Solution {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) return null;

        if (root.val==key) {
            if (root.left==null) return root.right;
            else if (root.right==null) return root.left;
            else {
                TreeNode rightMin=root.right;
                while(rightMin.left!=null) rightMin=rightMin.left;

                rightMin.right=deleteNode(root.right, rightMin.val);
                rightMin.left=root.left;
                root=rightMin;
            }
        } else if (root.val>key) {
            root.left=deleteNode(root.left, key);
        } else if (root.val<key) {
            root.right=deleteNode(root.right, key);
        }

        return root;
    }
}
