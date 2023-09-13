package practices.binary_tree.s1612;

public class Solution {
    private static class Node {
        char val;
        Node left;
        Node right;
        Node() {this.val = ' ';}
        Node(char val) { this.val = val; }
        Node(char val, Node left, Node right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }
    public boolean checkEquivalence(Node root1, Node root2) {
        int[] sum = leafSum(root1, root2);
        return sum[0]==sum[1];
    }

    int[] leafSum (Node root1, Node root2) {
        if (root1==null||root2==null) return new int[]{0, 0};

        int[] leftSum=leafSum(root1.left, root2.left);
        int[] rightSum=leafSum(root1.right, root2.right);

        int[] sum={leftSum[0]+rightSum[0], leftSum[1]+rightSum[1]};

        if (root1.left==null&&root1.right==null) sum[0]+=root1.val;
        if (root2.left==null&&root2.right==null) sum[1]+=root2.val;

        return sum;
    }
}
