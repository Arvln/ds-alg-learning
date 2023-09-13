package questions.graph.s1135;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

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
    private boolean[] inMST;
    private int weightSum;
    private List<int[]>[] graph;

    public Prim(List<int[]>[] graph) {
        this.graph=graph;
        pq=new PriorityQueue<>((a, b)->a[2]-b[2]);
        inMST=new boolean[graph.length];

        inMST[0]=true;
        cut(0);

        while(!pq.isEmpty()) {
            int[] poll = pq.poll();
            int to=poll[1], weight=poll[2];

            if (inMST[to]) continue;
            inMST[to]=true;
            weightSum+=weight;
            cut(to);
        }
    }

    public int weightSum() { return weightSum; }

    public boolean allConnected() {
        for (boolean v : inMST) {
            if (!v) return false;
        }

        return true;
    }

    private void cut(int s) {
        for (int[] edge : graph[s]) {
            int to=edge[1];

            if (inMST[to]) continue;
            pq.offer(edge);
        }
    }
}

public class Solution {
    public int minimumCostKruskal(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n+1);

        Arrays.sort(connections, (a, b)->a[2]-b[2]);
        int mst=0;
        for (int[] edge : connections) {
            int u=edge[0], v=edge[1], weight=edge[2];

            if (uf.isConnected(u, v)) continue;
            mst+=weight;
            uf.union(u, v);
        }

        return uf.count()==2 ? mst : -1;
    }

    public int minimumCostPrim(int n, int[][] connections) {
        List<int[]>[] graph = buildGraph(n, connections);
        Prim prim = new Prim(graph);

        if (!prim.allConnected()) return -1;
        return prim.weightSum();
    }

    private List<int[]>[] buildGraph(int n, int[][] connections) {
        List<int[]>[] graph = new LinkedList[n];

        for (int i = 0; i < n; i++) graph[i]=new LinkedList<>();

        for (int[] edge : connections) {
            int u=edge[0]-1, v=edge[1]-1, weight=edge[2];

            graph[u].add(new int[]{u, v, weight});
            graph[v].add(new int[]{v, u, weight});
        }

        return graph;
    }
}
