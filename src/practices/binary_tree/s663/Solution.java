package practices.binary_tree.s663;

import practices.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> record=new ArrayList<>();
    public boolean checkEqualTree(TreeNode root) {
        int total=subTreeSum(root);

        if (total%2==1) return false;
        return record.contains(total/2);
    }

    int subTreeSum(TreeNode root) {
        if (root==null) return 0;

        int leftSum=subTreeSum(root.left);
        int rightSum=subTreeSum(root.right);

        int curSum=root.val+leftSum+rightSum;
        record.add(curSum);

        return curSum;
    }
}
