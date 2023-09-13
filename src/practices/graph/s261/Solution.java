package practices.graph.s261;

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
    boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int[] inDegree=new int[n];

        for (int[] edge : edges) {
            int from=edge[0], to=edge[1];

            if (uf.isConnected(from, to)||inDegree[to]>0) return false;
            uf.union(from, to);
            inDegree[to]++;
        }
        return uf.count()==1;
    }
}
