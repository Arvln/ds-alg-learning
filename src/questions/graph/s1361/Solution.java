package questions.graph.s1361;

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
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UnionFind uf=new UnionFind(n);
        int[] indegree=new int[n];

        for (int i=0; i<leftChild.length; i++) {
            if (leftChild[i]<0) continue;
            else if (uf.isConnected(i, leftChild[i])) return false;
            else {
                if (indegree[leftChild[i]]==0) {
                    uf.union(i, leftChild[i]);
                    indegree[leftChild[i]]++;
                }
            }
        }

        for (int i=0; i<rightChild.length; i++) {
            if (rightChild[i]<0) continue;
            else if (uf.isConnected(i, rightChild[i])) return false;
            else {
                if (indegree[rightChild[i]]==0) {
                    uf.union(i, rightChild[i]);
                    indegree[rightChild[i]]++;
                }
            }
        }
        return uf.count()==1;
    }
}
