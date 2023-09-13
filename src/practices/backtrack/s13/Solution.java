package practices.backtrack.s13;

public class Solution {
    public int movingCount(int m, int n, int k) {
        return dfs(m, n, 0, 0, k, new boolean[m][n]);
    }
    int dfs(int m, int n, int i, int j, int k, boolean[][] onPath)
    {
        int sum=(i/10)+(i%10)+(j/10)+(j%10);
        if (i<0||j<0||i>=m||j>=n) return 0;
        if (sum>k) return 0;
        if (onPath[i][j]) return 0;

        onPath[i][j]=true;
        return 1+dfs(m, n, i-1, j, k, onPath)+
                dfs(m, n, i+1, j, k, onPath)+
                dfs(m, n, i, j-1, k, onPath)+
                dfs(m, n, i, j+1, k, onPath);
    }
}
