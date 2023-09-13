package questions.binary_tree.s104;

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
    private int depth;
    private int maxDepth;

    public int maxDepth1(TreeNode root) {
        depth=0;
        traverse(root);
        return maxDepth;
    }
    void traverse(TreeNode root) {
        if (root==null) return;

        depth++;
        traverse(root.left);
        traverse(root.right);
        maxDepth=Math.max(maxDepth, depth);
        depth--;
    }

    public int maxDepth2(TreeNode root) {
        if (root==null) return 0;

        int leftMaxDepth=maxDepth2(root.left);
        int rightMaxDepth=maxDepth2(root.right);

        return Math.max(leftMaxDepth, rightMaxDepth)+1;
    }
}
