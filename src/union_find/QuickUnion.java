package union_find;

public class QuickUnion {
    private int[] parent;
    private int count;

    public QuickUnion(int count) {
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
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        parent[rootP] = rootQ;
        count = count - 1;
    }
}
