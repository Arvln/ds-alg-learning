package practices.binary_tree.s508;

import practices.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    private int maxCount=0;
    private ArrayList<Integer> sums=new ArrayList<>();
    private HashMap<Integer, Integer> sumToCount=new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        sum(root);

        int[] res=new int[sums.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]=sums.get(i);
        }
        return res;
    }

    int sum(TreeNode root) {
        if (root==null) return 0;

        int leftSum=sum(root.left);
        int rightSum=sum(root.right);
        int curSum=root.val+leftSum+rightSum;

        sumToCount.put(curSum, sumToCount.getOrDefault(curSum, 0)+1);
        int count=sumToCount.get(curSum);

        if (count>maxCount) {
            maxCount=count;
            sums.clear();
        }
        if (count==maxCount) sums.add(curSum);

        return curSum;
    }
}
