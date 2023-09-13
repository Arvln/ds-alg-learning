package graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    private static class State {
        private final int id;
        private final int distFromStart;

        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    public Dijkstra(List<int[]>[] graph) {
        this.graph = graph;
    }

    private List<int[]>[] graph;

    private List<int[]> adj(int s) {
        return graph[s];
    }

    private int weight(int from, int to) {
        List<int[]> edges = adj(from);

        for (int[] edge : edges) {
            if (edge[1] == to) {
                return edge[2];
            }
        }

        return -1;
    }

    public int[] dijkstra(int start) {
        int V = graph.length;
        int[] distTo = new int[V];
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distFromStart));

        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State currentState = pq.poll();

            if (currentState.distFromStart > distTo[currentState.id]) continue;

            for (int[] edge : adj(currentState.id)) {
                int nextId = edge[1];
                int distToNext = distTo[currentState.id] + weight(currentState.id, nextId);

                if (distToNext < distTo[nextId]) {
                    distTo[nextId] = distToNext;
                    pq.offer(new State(nextId, distToNext));
                }
            }
        }

        return distTo;
    }
}
