package union_find;

public class PathCompressionQuickUnion {
    private int[] parent;
    private int count;

    public PathCompressionQuickUnion(int count) {
        parent = new int[count];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        this.count = count;
    }

    public int count() { return count; }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        int root = p;
        while (root != parent[root]) {
            root = parent[root];
        }
        while (p != root) {
            int nextP = parent[p];
            parent[p] = root;
            p = nextP;
        }

        return root;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        parent[rootP] = rootQ;
        count = count - 1;
    }
}
