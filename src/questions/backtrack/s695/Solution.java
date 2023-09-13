package questions.backtrack.s695;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        if (m==0) return 0;
        int n=grid[0].length;

        int[][] dirs=new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        int max=0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j]!=1) continue;

                int count=0;
                Queue<int[]> q=new LinkedList<>();
                count++;
                q.offer(new int[]{i, j});
                grid[i][j]=2;
                while(!q.isEmpty()) {
                    int x=q.peek()[0], y=q.peek()[1];
                    q.poll();

                    for (int[] dir : dirs) {
                        int nx=x+dir[0], ny=y+dir[1];

                        if (nx<0||ny<0||nx>=m||ny>=n) continue;
                        if (grid[nx][ny]!=1) continue;

                        count++;
                        q.offer(new int[]{nx, ny});
                        grid[nx][ny]=2;
                    }
                }
                max=Math.max(max, count);
            }
        }
        return max;
    }

    public int maxAreaOfIslandDFS(int[][] grid) {
        int m=grid.length;
        if (m==0) return 0;
        int n=grid[0].length;

        int res=0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j]!=1) continue;

                res=Math.max(res, dfs(grid, i, j));
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
