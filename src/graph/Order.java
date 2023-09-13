package graph;

import stack.LinkedListStack;

public class Order {
    private final boolean[] marked;
    private final LinkedListStack<Integer> reversePost;

    public Order(Digraph g) {
        marked = new boolean[g.useVertices()];
        reversePost = new LinkedListStack<>();

        for (int v = 0; v < g.useVertices(); v++) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;

        for (Integer current : g.useAdj(v)) {
            if (!marked[current]) {
                dfs(g, current);
            }
        }

        reversePost.push(v);
    }

    public LinkedListStack<Integer> reversePost() {
        return reversePost;
    }
}
