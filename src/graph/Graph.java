package graph;

import queue.LinkedListQueue;
import queue.Queue;

public class Graph {
    private final int V;
    private int E;
    private final LinkedListQueue<Integer>[] adj;

    @SuppressWarnings("all")
    public Graph(int V) {
        this.V = V;
        E = 0;
        adj = new LinkedListQueue[V];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedListQueue<>();
        }
    }

    public int useVertices() {
        return V;
    }

    public int useEdges() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].offer(w);
        adj[w].offer(v);

        E = E + 1;
    }

    public LinkedListQueue<Integer> useAdj(int V) {
        return adj[V];
    }
}
