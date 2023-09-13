package union_find;

public class QuickFind {
    private int[] id;
    private int count;

    public QuickFind(int count) {
        id = new int[count];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }

        this.count = count;
    }

    public int count() { return count; }

    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        if (isConnected(p, q)) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == id[p]) {
                id[i] = id[q];
            }
        }

        count = count - 1;
    }
}
