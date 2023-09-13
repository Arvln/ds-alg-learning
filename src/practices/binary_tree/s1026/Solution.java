package practices.binary_tree.s1026;

import practices.binary_tree.TreeNode;

import java.util.TreeMap;

public class Solution {
    private TreeMap<Integer, Integer> map=new TreeMap<>();
    private int V=0;
    public int maxAncestorDiff1(TreeNode root) {
        traverse1(root);
        return V;
    }

    void traverse1(TreeNode root) {
        if (root==null) return;

        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        traverse1(root.left);
        traverse1(root.right);
        int max=Math.max(Math.abs(root.val-map.firstKey()), Math.abs(root.val-map.lastKey()));
        V=Math.max(V, max);
        map.put(root.val, map.get(root.val)-1);
        if (map.get(root.val)==0) map.remove(root.val);
    }

    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, root.val, root.val);
    }

    int maxAncestorDiff(TreeNode root, int min, int max) {
        if (root==null) return 0;

        min=Math.min(min, root.val);
        max=Math.max(max, root.val);

        int leftMaxDiff=maxAncestorDiff(root.left, min, max);
        int rightMaxDiff=maxAncestorDiff(root.right, min, max);

        int maxDiff=Math.max(Math.abs(max-root.val), Math.abs(root.val-min));

        return Math.max(maxDiff, Math.max(leftMaxDiff, rightMaxDiff));
    }
}
