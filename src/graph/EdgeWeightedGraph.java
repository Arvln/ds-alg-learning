package graph;

import queue.LinkedListQueue;
import queue.Queue;

public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private LinkedListQueue<Edge>[] adj;

    @SuppressWarnings("all")
    public EdgeWeightedGraph(int V) {
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

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);

        adj[v].offer(e);
        adj[w].offer(e);

        E = E + 1;
    }

    public Queue<Edge> useAdj(int v) {
        return adj[v];
    }

    public LinkedListQueue<Edge> useAllEdges() {
        LinkedListQueue<Edge> edges = new LinkedListQueue<>();

        for (int v = 0; v < V; v++) {
            for (Edge edge : adj[v]) {
                if (v > edge.other(v)) {
                    edges.offer(edge);
                }
            }
        }

        return edges;
    }
}
