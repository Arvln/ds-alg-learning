package practices.binary_tree.s501;

import practices.binary_tree.TreeNode;

import java.util.ArrayList;

public class Solution {
    private TreeNode prev;
    private int maxCount=0, count=0;
    private ArrayList<Integer> modes=new ArrayList<>();
    public int[] findMode(TreeNode root) {
        traverse(root);
        int[] res=new int[modes.size()];

        for (int i = 0; i < res.length; i++) {
            res[i]=modes.get(i);
        }
        return res;
    }

    void traverse(TreeNode root) {
        if (root==null) return;

        traverse(root.left);

        if (prev==null) {
            count=1;
        } else if (prev.val == root.val) {
            count++;
        } else {
            count=1;
        }
        prev=root;

        if (count>maxCount) {
            maxCount=count;
            modes.clear();
        }
        if (count==maxCount) modes.add(root.val);

        traverse(root.right);
    }
}
