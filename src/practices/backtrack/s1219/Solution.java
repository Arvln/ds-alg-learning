package practices.backtrack.s1219;

public class Solution {
    public int getMaximumGold(int[][] grid) {
        int m=grid.length;
        if (m==0) return 0;
        int n=grid[0].length;

        int ret=0;
        for (int i=0; i<m; i++)
        {
            for (int j=0; j<n; j++)
            {
                if (grid[i][j]<1) continue;

                ret=Math.max(ret, dfs(grid, i, j));
            }
        }
        return ret;
    }
    int dfs(int[][] grid, int i, int j)
    {
        int m=grid.length, n=grid[0].length;
        if (i<0||j<0||i>=m||j>=n) return 0;
        if (grid[i][j]<1) return 0;

        int cur=grid[i][j];
        grid[i][j]=0;
        int row=Math.max(dfs(grid, i, j-1), dfs(grid, i, j+1));
        int col=Math.max(dfs(grid, i-1, j), dfs(grid, i+1, j));
        grid[i][j]=cur;
        return cur+Math.max(row, col);
    }
}
