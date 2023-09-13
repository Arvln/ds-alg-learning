package practices.binary_tree.s1008;

import practices.binary_tree.TreeNode;

public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length-1);
    }

    TreeNode build(int[] preorder, int start, int end) {
        if (start>end) return null;

        int rootVal=preorder[start];

        int left=start+1;
        while (left<=end&&preorder[left]<rootVal) left++;

        TreeNode cur=new TreeNode(rootVal);
        cur.left=build(preorder, start+1, left-1);
        cur.right=build(preorder, left, end);
        return cur;
    }
}
