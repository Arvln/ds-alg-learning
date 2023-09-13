package questions.backtrack.s1905;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int countSubIslandsBFS(int[][] grid1, int[][] grid2) {
        int m=grid2.length;
        if (m==0) return 0;
        int n=grid2[0].length;

        int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int count=0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid2[i][j]!=1) continue;

                boolean isSub=grid1[i][j]==1;
                Queue<int[]> q=new LinkedList<>();
                q.offer(new int[]{i, j});
                grid2[i][j]=2;
                while(!q.isEmpty()) {
                    int x=q.peek()[0], y=q.peek()[1];
                    q.poll();

                    for (int[] dir : dirs) {
                        int nx=x+dir[0], ny=y+dir[1];

                        if (nx<0||ny<0||nx>=m||ny>=n) continue;
                        if (grid2[nx][ny]!=1) continue;

                        isSub=isSub&&grid1[nx][ny]==1;
                        q.offer(new int[]{nx, ny});
                        grid2[nx][ny]=2;
                    }
                }
                if (isSub) count++;
            }
        }
        return count;
    }

    public int countSubIslandsDFS(int[][] grid1, int[][] grid2) {
        int m=grid2.length;
        if (m==0) return 0;
        int n=grid2[0].length;

        int res=0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid2[i][j]!=1) continue;
                if (isSubIsland(grid1, grid2, i, j)) res++;
            }
        }
        return res;
    }
    private boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j) {
        int m=grid2.length, n=grid2[0].length;
        if (i<0||j<0||i>=m||j>=n) return true;
        if (grid2[i][j]!=1) return true;

        grid2[i][j]=2;
        boolean top=isSubIsland(grid1, grid2, i-1, j);
        boolean down=isSubIsland(grid1, grid2, i+1, j);
        boolean left=isSubIsland(grid1, grid2, i, j-1);
        boolean right=isSubIsland(grid1, grid2, i, j+1);

        return grid1[i][j]==1&&top&&down&&left&&right;
    }
}
