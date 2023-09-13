package graph;

public class DFS {
    private final boolean[] marked;
    private int count;

    public DFS(Graph g, int s) {
        marked = new boolean[g.useVertices()];
        count = 0;

        dfs(g, s);
    }

    private void dfs(Graph g, int s) {
        marked[s] = true;
        count = count + 1;

        for (Integer v : g.useAdj(s)) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }
}
