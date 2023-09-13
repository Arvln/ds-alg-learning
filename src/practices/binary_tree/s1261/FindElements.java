package practices.binary_tree.s1261;

import practices.binary_tree.TreeNode;

import java.util.HashSet;

public class FindElements {
    private HashSet<Integer> values=new HashSet<>();
    public FindElements(TreeNode root) {
        root.val=0;
        traverse(root);
    }

    void traverse(TreeNode root) {
        if (root==null) return;

        values.add(root.val);
        if (root.left!=null) root.left.val=2*root.val+1;
        if (root.right!=null) root.right.val=2*root.val+2;

        traverse(root.left);
        traverse(root.right);
    }

    public boolean find(int target) {
        return values.contains(target);
    }
}
