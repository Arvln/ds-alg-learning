package practices.graph.s1584;

import java.util.LinkedList;
import java.util.List;

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

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges=new LinkedList<>();

        for (int i=0; i<points.length; i++) {
            for (int j=i+1; j<points.length; j++) {
                int xi=points[i][0], yi=points[i][1];
                int xj=points[j][0], yj=points[j][1];
                int dis=Math.abs(xi - xj)+Math.abs(yi - yj);

                edges.add(new int[]{i, j, dis});
            }
        }

        UnionFind uf=new UnionFind(points.length);
        edges.sort((a, b)->a[2]-b[2]);

        int mst=0;
        for (int[] edge : edges) {
            int i=edge[0], j=edge[1], dis=edge[2];

            if (uf.isConnected(i, j)) continue;
            mst+=dis;
            uf.union(i, j);
        }
        return mst;
    }
}
