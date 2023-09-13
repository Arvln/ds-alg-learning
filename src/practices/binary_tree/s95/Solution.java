package practices.binary_tree.s95;

import practices.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new LinkedList<>();

        return build(1, n);
    }

    List<TreeNode> build(int low, int high) {
        List<TreeNode> res=new LinkedList<>();
        if (low>high) {
            res.add(null);
            return res;
        }

        for(int i=low; i<=high; i++) {
            List<TreeNode> leftTree=build(low, i-1);
            List<TreeNode> rightTree=build(i+1, high);

            for (TreeNode left: leftTree) {
                for (TreeNode right: rightTree) {
                    TreeNode cur=new TreeNode(i, left, right);
                    res.add(cur);
                }
            }
        }

        return res;
    }
}
