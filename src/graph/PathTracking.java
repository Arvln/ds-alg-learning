package graph;

import stack.LinkedListStack;

import java.util.Arrays;

public class PathTracking {
    private final boolean[] marked;
    private final int start;
    private final int[] edgeTo;

    public PathTracking(Graph g, int s) {
        marked = new boolean[g.useVertices()];
        start = s;
        edgeTo = new int[g.useVertices()];

        dfs(g, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;

        for (Integer current : g.useAdj(v)) {
            if (!marked[current]) {
                edgeTo[current] = v;
                dfs(g, current);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public LinkedListStack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        LinkedListStack<Integer> path = new LinkedListStack<>();

        for (int current = v; current != start; current = edgeTo[current]) {
            path.push(current);
        }

        path.push(start);

        return path;
    }
}
