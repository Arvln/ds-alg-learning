package practices.binary_tree.s889;

import practices.binary_tree.TreeNode;

import java.util.HashMap;

public class Solution {
    private HashMap<Integer, Integer> valToIndex=new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length-1,
                postorder,0 , postorder.length-1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] postorder, int postStart, int postEnd) {
        if (postStart>postEnd) return null;
        if (postStart==postEnd) return new TreeNode(preorder[preStart]);

        int rootVal=preorder[preStart];
        int leftSize=valToIndex.get(preorder[preStart+1])-postStart+1;

        TreeNode cur=new TreeNode(rootVal);
        cur.left=build(
                preorder, preStart+1, preStart+leftSize,
                postorder, postStart, postStart+leftSize-1
        );
        cur.right=build(
                preorder, preStart+leftSize+1, preEnd,
                postorder, postStart+leftSize, postEnd-1
        );
        return cur;
    }
}
