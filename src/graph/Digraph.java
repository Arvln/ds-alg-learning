package graph;

import queue.LinkedListQueue;

public class Digraph {
    private final int V;
    private int E;
    private final LinkedListQueue<Integer>[] adj;

    @SuppressWarnings("all")
    public Digraph(int V) {
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
        E = E + 1;
    }

    public LinkedListQueue<Integer> useAdj(int v) {
        return adj[v];
    }

    private Digraph reverse() {
        Digraph digraph = new Digraph(V);

        for (int v = 0; v < adj.length; v++) {
            for (Integer current : adj[v]) {
                addEdge(current, v);
            }
        }

        return digraph;
    }
}
