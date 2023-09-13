package questions.binary_tree.s297;

import java.util.LinkedList;
import java.util.Queue;

public class Codec3 {
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

    private String SEP=",";
    private String NULL="#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur==null) {
                sb.append(NULL).append(SEP);
                continue;
            } else {
                sb.append(cur.val).append(SEP);
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] nodes=data.split(SEP);
        TreeNode root=new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < nodes.length;) {
            TreeNode cur=queue.poll();

            String left=nodes[i++];
            if (NULL.equals(left)) {
                cur.left=null;
            } else {
                cur.left=new TreeNode(Integer.parseInt(left));
                queue.offer(cur.left);
            }

            String right=nodes[i++];
            if (NULL.equals(right)) {
                cur.right=null;
            } else {
                cur.right=new TreeNode(Integer.parseInt(right));
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
