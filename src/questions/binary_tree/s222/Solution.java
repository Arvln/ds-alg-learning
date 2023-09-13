package questions.binary_tree.s222;

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

    public int countNodes(TreeNode root) {
        if (root==null) return 0;

        TreeNode l=root, r=root;
        int hl=0, hr=0;
        while (l!=null) {
            l=l.left;
            hl++;
        }
        while (r!=null) {
            r=r.right;
            hr++;
        }

        if (hl==hr) return (int)Math.pow(2, hl)-1;

        int left=countNodes(root.left);
        int right=countNodes(root.right);

        return left+right+1;
    }
}
