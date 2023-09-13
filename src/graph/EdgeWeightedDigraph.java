package graph;

import queue.LinkedListQueue;

public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private final LinkedListQueue<DirectedEdge>[] adj;

    @SuppressWarnings("all")
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        E = 0;
        adj = new LinkedListQueue[V];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedListQueue<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        int from = e.from();

        adj[from].offer(e);

        E = E + 1;
    }

    public LinkedListQueue<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public LinkedListQueue<DirectedEdge> edges() {
        LinkedListQueue<DirectedEdge> edges = new LinkedListQueue<>();

        for (int v = 0; v < V; v++) {
            for (DirectedEdge directedEdge : adj[v]) {
                edges.offer(directedEdge);
            }
        }

        return edges;
    }
}
