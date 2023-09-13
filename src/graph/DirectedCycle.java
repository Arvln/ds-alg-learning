package graph;

public class DirectedCycle {
    private final boolean[] marked;
    private boolean hasCycle;
    private final boolean[] onStack;

    public DirectedCycle(Digraph g) {
        marked = new boolean[g.useVertices()];
        hasCycle = false;
        onStack = new boolean[g.useVertices()];

        for (int v = 0; v < g.useVertices(); v++) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        onStack[v] = true;

        for (Integer current : g.useAdj(v)) {
            if (!marked[current]) {
                dfs(g, current);
            }

            if (onStack[current]) {
                hasCycle = true;
                return;
            }
        }

        onStack[v] = false;
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
