package questions.binary_tree.s889;

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

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        valToIndex=new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }
        return build(
                preorder, 0, preorder.length-1,
                postorder, 0, postorder.length-1
        );
    }

    TreeNode build(
            int[] preorder, int preStart, int preEnd,
            int[] postorder, int postStart, int postEnd
    ) {
        if (preStart>preEnd) return null;
        if (preStart==preEnd) return new TreeNode(preorder[preStart]);

        int curVal=preorder[preStart];
        int index=valToIndex.get(preorder[preStart+1]);
        int leftSize=index-postStart+1;

        TreeNode cur=new TreeNode(curVal);
        cur.left=build(
                preorder, preStart+1, preStart+leftSize,
                postorder, postStart, index
        );
        cur.right=build(
                preorder, preStart+leftSize+1, preEnd,
                postorder, index+1, postEnd-1
        );
        return cur;
    }
}
