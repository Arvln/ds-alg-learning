package questions.binary_tree.s105;

import java.util.HashMap;

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

    private HashMap<Integer, Integer> valToIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        valToIndex=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(
                preorder, 0, preorder.length-1,
                inorder, 0, inorder.length-1
        );
    }

    TreeNode build(
            int[] preorder, int preStart, int preEnd,
            int[] inorder, int inStart, int inEnd
    ) {
        if (preStart>preEnd) return null;

        int curVal=preorder[preStart];
        int index=valToIndex.get(curVal);
        int leftSize=index-inStart;
        TreeNode cur=new TreeNode(curVal);
        cur.left=build(
                preorder, preStart+1, preStart+leftSize,
                inorder, inStart, index-1
        );
        cur.right=build(
                preorder, preStart+leftSize+1, preEnd,
                inorder, index+1, inEnd
        );
        return cur;
    }
}
