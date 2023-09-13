package union_find;

public class WeightedQuickUnion {
    private int[] parent;
    private int[] size;
    private int count;

    public WeightedQuickUnion(int count) {
        parent = new int[count];
        size = new int[count];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
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

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }

        count = count - 1;
    }
}
