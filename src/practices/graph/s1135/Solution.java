package practices.graph.s1135;

import java.util.Arrays;

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
    public int minimumCost(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        Arrays.sort(connections, (a, b)->a[2]-b[2]);

        int mst=0;
        for (int[] connection : connections) {
            int x=connection[0]-1, y=connection[1]-1, cost=connection[2];

            if (uf.isConnected(x, y)) continue;
            mst+=cost;
            uf.union(x, y);
        }
        return uf.count()==1 ? mst : -1;
    }
}
