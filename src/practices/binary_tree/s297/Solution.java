package practices.binary_tree.s297;

import practices.binary_tree.TreeNode;

import java.util.LinkedList;

public class Solution {
    private String SEP=",", NULL="#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    void serialize(TreeNode root, StringBuilder sb) {
        if (root==null) {
            sb.append(NULL).append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] allNodes = data.split(SEP);
        LinkedList<String> nodes=new LinkedList<>();

        for (int i = 0; i < allNodes.length; i++) {
            nodes.addLast(allNodes[i]);
        }
        return deserialize(nodes);
    }

    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        String node=nodes.removeFirst();
        if (NULL.equals(node)) return null;
        TreeNode root=new TreeNode(Integer.parseInt(node));

        root.left=deserialize(nodes);
        root.right=deserialize(nodes);
        return root;
    }
}
