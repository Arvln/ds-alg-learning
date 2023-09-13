package questions.backtrack.s1020;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        if (m==0) return 0;
        int n=grid[0].length;

        for (int j=0; j<n; j++) {
            bfs(grid, 0, j);
            bfs(grid, m-1, j);
        }
        for (int i=0; i<m; i++) {
            bfs(grid, i, 0);
            bfs(grid, i, n-1);
        }

        int count=0;
        for (int i=1; i<m-1; i++) {
            for (int j=1; j<n-1; j++) {
                if (grid[i][j]!=1) continue;

                count+=bfs(grid, i, j);
            }
        }
        return count;
    }
    private int[][] dirs=new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    private int bfs(int[][] grid, int i, int j) {
        if (grid[i][j]!=1) return 0;

        int m=grid.length, n=grid[0].length;
        int count=0;
        Queue<int[]> q=new LinkedList<>();
        count++;
        q.offer(new int[]{i, j});
        grid[i][j]=2;

        while(!q.isEmpty()) {
            int x=q.peek()[0], y=q.peek()[1];
            q.poll();

            for(int[] dir : dirs) {
                int nx=x+dir[0], ny=y+dir[1];

                if (nx<0||ny<0||nx>=m||ny>=n) continue;
                if (grid[nx][ny]!=1) continue;

                count++;
                q.offer(new int[]{nx, ny});
                grid[nx][ny]=2;
            }
        }
        return count;
    }
    public int numEnclavesDFS(int[][] grid) {
        int m=grid.length;
        if (m==0) return 0;
        int n=grid[0].length;

        for (int j=0; j<n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m-1, j);
        }
        for (int i=0; i<m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n-1);
        }

        int res=0;
        for (int i=1; i<m-1; i++) {
            for (int j=1; j<n-1; j++) {
                if (grid[i][j]!=1) continue;

                res+=dfs(grid, i, j);
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        int m=grid.length, n=grid[0].length;

        if (i<0||j<0||i>=m||j>=n) return 0;
        if (grid[i][j]!=1) return 0;

        grid[i][j]=2;
        return 1+dfs(grid, i-1, j)+dfs(grid, i+1, j)+dfs(grid, i, j-1)+dfs(grid, i, j+1);
    }
}
