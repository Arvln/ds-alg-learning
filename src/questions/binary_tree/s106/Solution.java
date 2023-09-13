package questions.binary_tree.s106;

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        valToIndex=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(
                inorder, 0, inorder.length-1,
                postorder, 0, postorder.length-1
        );
    }

    TreeNode build(
            int[] inorder, int inStart, int inEnd,
            int[] postorder, int postStart, int postEnd
    ) {
        if (postStart>postEnd) return null;

        int curVal=postorder[postEnd];
        int index=valToIndex.get(curVal);
        int leftSize=index-inStart;

        TreeNode cur=new TreeNode(curVal);
        cur.left=build(
                inorder, inStart, index-1,
                postorder, postStart, postStart+leftSize-1
        );
        cur.right=build(
                inorder, index+1, inEnd,
                postorder, postStart+leftSize, postEnd-1
        );
        return cur;
    }
}
