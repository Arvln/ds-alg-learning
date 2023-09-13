package graph;

import queue.LinkedListQueue;
import union_find.PathCompressionQuickUnion;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {
    private LinkedListQueue<int[]> mst;
    private PathCompressionQuickUnion uf;
    private PriorityQueue<int[]> pq;

    public Kruskal(List<int[]>[] graph) {
        mst = new LinkedListQueue<>();
        uf = new PathCompressionQuickUnion(graph.length);
        pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (List<int[]> edges : graph) {
            for (int[] edge : edges) {
                pq.offer(edge);
            }
        }

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int from = edge[0];
            int to = edge[1];

            if (uf.isConnected(from, to)) continue;

            uf.union(from, to);
            mst.offer(edge);
        }
    }

    public LinkedListQueue<int []> edges() {
        return mst;
    }
}
