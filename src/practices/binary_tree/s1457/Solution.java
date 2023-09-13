package practices.binary_tree.s1457;

import practices.binary_tree.TreeNode;

import java.util.HashMap;

public class Solution {
    private int oddCount=0, count=0;
    private HashMap<Integer, Integer> records=new HashMap<>();
    public int pseudoPalindromicPaths (TreeNode root) {
        traverse(root);
        return count;
    }

    void traverse(TreeNode root) {
        if (root==null) return;

        records.put(root.val, records.getOrDefault(root.val, 0)+1);
        if (records.get(root.val)%2==1) oddCount++;
        else oddCount--;
        if(root.left==null&&root.right==null&&oddCount<=1) count++;

        traverse(root.left);
        traverse(root.right);

        records.put(root.val, records.get(root.val)-1);
        if (records.get(root.val)%2==1) oddCount++;
        else oddCount--;
    }
}
