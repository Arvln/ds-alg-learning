package practices.graph.s542;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        int[][] distTo=new int[m][n];

        for (int[] row: distTo) Arrays.fill(row, -1);

        Queue<int[]> q=new LinkedList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j]==0) {
                    q.offer(new int[]{i, j});
                    distTo[i][j]=0;
                }
            }
        }

        int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()) {
            int[] cur=q.poll();
            int x=cur[0], y=cur[1];

            for (int[] dir: dirs) {
                int nx=x+dir[0], ny=y+dir[1];

                if (nx<0||nx>=m||ny<0||ny>=n) continue;
                if (distTo[nx][ny]==-1) {
                    distTo[nx][ny]=distTo[x][y]+1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return distTo;
    }
}
