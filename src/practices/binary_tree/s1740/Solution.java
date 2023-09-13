package practices.binary_tree.s1740;

import practices.binary_tree.TreeNode;

public class Solution {
    private int pDepth=-1, qDepth=-1, dis=0;
    public int findDistance(TreeNode root, int p, int q) {
        traverse(root, p, q, 0, 0);
        return dis;
    }

    void traverse(TreeNode root, int p, int q, int depth, int visitRoot) {
        if (root==null) return;

        if (depth==0) visitRoot++;
        if (root.val==p) pDepth=depth;
        if (root.val==q) qDepth=depth;
        if (pDepth>-1&&qDepth>-1) {
            if (visitRoot>1) dis=pDepth+qDepth;
            else dis=Math.abs(pDepth-qDepth);

            return;
        }
        depth++;

        traverse(root.left, p, q, depth, visitRoot);
        traverse(root.right, p, q, depth, visitRoot);
    }
}
