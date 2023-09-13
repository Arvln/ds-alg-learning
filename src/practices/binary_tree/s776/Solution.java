package practices.binary_tree.s776;

import practices.binary_tree.TreeNode;

public class Solution {
    private TreeNode[] res=new TreeNode[2];
    public TreeNode[] splitBST(TreeNode root, int target) {
        res[0]=build(root, target);
        return res;
    }

    TreeNode build(TreeNode root, int target) {
        if (root==null) return null;

        if (root.val<=target) {
            res[1]=root;
            return build(root.right, target);
        } else {
            root.left=build(root.left, target);
            root.right=build(root.right, target);
            return root;
        }
    }
}
