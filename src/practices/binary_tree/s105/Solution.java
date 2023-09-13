package practices.binary_tree.s105;

import practices.binary_tree.TreeNode;

import java.util.HashMap;

public class Solution {
    private HashMap<Integer, Integer> valToIndex=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(
                preorder, 0, preorder.length-1,
                inorder, 0, inorder.length-1
        );
    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {
        if (preStart>preEnd) return null;

        int rootVal=preorder[preStart];

        int rootIndex=valToIndex.get(rootVal);
        int leftSize=rootIndex-inStart;

        TreeNode cur=new TreeNode(rootVal);

        cur.left=build(
                preorder, preStart+1, preStart+leftSize,
                inorder, inStart, rootIndex-1
        );
        cur.right=build(
                preorder, preStart+leftSize+1, preEnd,
                inorder, rootIndex+1, inEnd
        );
        return cur;
    }
}
