package questions.backtrack.s200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int numIslandsBFS(char[][] grid) {
        int m=grid.length;
        if (m==0) return 0;
        int n=grid[0].length;

        int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int count=0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] != '1') continue;

                count++;
                Queue<int[]> q=new LinkedList<>();
                q.offer(new int[]{i, j});
                grid[i][j]='2';
                while(!q.isEmpty()) {
                    int x=q.peek()[0], y=q.peek()[1];
                    q.poll();

                    for (int[] dir : dirs) {
                        int nx=x+dir[0], ny=y+dir[1];

                        if(nx<0||ny<0||nx>=m||ny>=n) continue;
                        if (grid[nx][ny] != '1') continue;

                        q.offer(new int[]{nx, ny});
                        grid[nx][ny]='2';
                    }
                }
            }
        }
        return count;
    }

    public int numIslandsDFS(char[][] grid) {
        int m=grid.length;
        if (m==0) return 0;
        int n=grid[0].length;

        int res=0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] != '1') continue;

                res++;
                dfs(grid, i, j);
            }
        }
        return res;
    }
    private void dfs(char[][] grid, int i, int j) {
        int m=grid.length, n=grid[0].length;
        if (i<0||j<0||i>=m||j>=n) return;
        if (grid[i][j]!='1') return;

        grid[i][j]='0';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
