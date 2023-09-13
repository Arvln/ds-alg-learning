package questions.graph.s1584;

import java.util.*;

class UnionFind {
    private int count;
    private int[] parent;

    public UnionFind(int count) {
        parent=new int[count];

        for (int i = 0; i < parent.length; i++) {
            parent[i]=i;
        }
        this.count=count;
    }

    public int count() { return count; }

    public boolean isConnected(int p, int q) { return find(p)==find(q); }

    private int find(int p) {
        int root=p;
        while (root!=parent[root]) root=parent[root];
        while (p!=parent[p]) {
            int nextP=parent[p];
            parent[p]=root;
            p=nextP;
        }

        return root;
    }

    public void union(int p, int q) {
        int rootP=find(p), rootQ=find(q);

        if (rootP==rootQ) return;

        parent[rootP]=rootQ;
        count--;
    }
}

class Prim {
    private PriorityQueue<int[]> pq;
    private List<int[]>[] graph;
    private int weightSum;
    private boolean[] inMST;

    private void cut(int s) {
        for (int[] edge : graph[s]) {
            int to=edge[1];

            if (inMST[to]) continue;
            pq.offer(edge);
        }
    }

    public Prim(List<int[]>[] graph) {
        this.graph=graph;
        pq=new PriorityQueue<>((a, b)->a[2]-b[2]);
        weightSum=0;
        inMST=new boolean[graph.length];

        inMST[0]=true;
        cut(0);
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int to=poll[1], weight=poll[2];

            if (inMST[to]) continue;
            inMST[to]=true;
            weightSum+=weight;
            cut(to);
        }
    }

    public int weight() { return weightSum; }

    public boolean allConnected() {
        for (boolean isV : inMST) {
            if (!isV) return false;
        }
        return true;
    }
}

public class Solution {
    public int minCostConnectPointsKruskal(int[][] points) {
        int n=points.length;
        List<int[]> edges=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int xi=points[i][0], yi=points[i][1];
                int xj=points[j][0], yj=points[j][1];
                int weight=Math.abs(xi-xj)+Math.abs(yi-yj);

                edges.add(new int[]{i, j, weight});
            }
        }

        edges.sort((a, b)->a[2]-b[2]);
        UnionFind uf = new UnionFind(n);
        int mst=0;
        for (int[] edge : edges) {
            int v=edge[0], w=edge[1], weight=edge[2];

            if (uf.isConnected(v, w)) continue;
            mst+=weight;
            uf.union(v, w);
        }

        return mst;
    }

    public int minCostConnectPointsPrim(int[][] points) {
        List<int[]>[] graph = buildGraph(points);
        Prim prim = new Prim(graph);
        return prim.weight();
    }

    List<int[]>[] buildGraph(int[][] points) {
        List<int[]>[] graph = new LinkedList[points.length];

        for (int i = 0; i < graph.length; i++) graph[i]=new LinkedList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                int xi=points[i][0], yi=points[i][1];
                int xj=points[j][0], yj=points[j][1];
                int weight=Math.abs(xi-xj)+Math.abs(yi-yj);

                graph[i].add(new int[]{i, j, weight});
                graph[j].add(new int[]{j, i, weight});
            }
        }

        return graph;
    }
}
