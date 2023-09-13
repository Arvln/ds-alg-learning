package questions.graph.s323;

class UnionFind {
    private int count;
    private int[] parent;

    public UnionFind(int count) {
        parent=new int[count];

        for (int i = 0; i < count; i++) {
            parent[i]=i;
        }

        this.count=count;
    }

    public int count() { return count; }

    public boolean isConnected(int p, int q) { return find(p)==find(q); }

    public int find(int p) {
        int root=p;

        while (root!=parent[root]) {
            root=parent[root];
        }
        while (p!=parent[p]) {
            int nextP=parent[p];
            parent[p]=root;
            p=nextP;
        }

        return root;
    }

    public void union(int p, int q) {
        int rootP=find(p);
        int rootQ=find(q);

        if (rootP==rootQ) return;

        parent[rootP]=rootQ;
        count--;
    }
}

public class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.count();
    }
}
