package graph;

import queue.LinkedListQueue;

public class BFS {
    private final boolean[] marked;
    private int count;

    public BFS(Graph g, int s) {
        marked = new boolean[g.useVertices()];
        count = 0;

        bfs(g, s);
    }

    private void bfs(Graph g, int s) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        queue.offer(s);

        while (!queue.isEmpty()) {
            Integer top = queue.poll();

            for (Integer v : g.useAdj(top)) {
                if (!marked[v]) {
                    marked[v] = true;
                    count = count + 1;
                    queue.offer(v);
                }
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
