package practices.binary_tree.s106;

import practices.binary_tree.TreeNode;

import java.util.HashMap;

public class Solution {
    private HashMap<Integer, Integer> valToIndex=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(
                inorder, 0, inorder.length-1,
                postorder, 0, postorder.length-1
        );
    }

    TreeNode build(int[] inorder, int inStart, int inEnd,
                   int[] postorder, int postStart, int postEnd) {
        if (postStart>postEnd) return null;

        int rootVal=postorder[postEnd];

        int index=valToIndex.get(rootVal);
        int leftSize=index-inStart;

        TreeNode cur=new TreeNode(rootVal);
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
