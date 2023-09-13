package practices.graph.s1631;

import java.util.*;

public class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length, n=heights[0].length;
        int[][] effortTo=new int[m][n];
        for (int i=0; i<m; i++) Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        effortTo[0][0]=0;

        Queue<int[]> pq=new PriorityQueue<>((a, b)->a[2]-b[2]);
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur=pq.poll();
            int x=cur[0], y=cur[1], effortFromStart=cur[2];

            if (x==m-1&&y==n-1) return effortFromStart;
            if (effortFromStart>effortTo[x][y]) continue;

            for (int[] next : adj(x, y, heights)) {
                int nextX=next[0], nextY=next[1], nextEffortFromStart=Math.max(effortFromStart, next[2]);

                if (effortTo[nextX][nextY]>nextEffortFromStart) {
                    effortTo[nextX][nextY]=nextEffortFromStart;
                    pq.offer(new int[]{nextX, nextY, nextEffortFromStart});
                }
            }
        }
        return -1;
    }

    int[][] dirs=new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

    List<int[]> adj(int x, int y, int[][] heights) {
        int m=heights.length, n=heights[0].length;
        List<int[]> edges=new LinkedList<>();

        for (int[] dir : dirs) {
            int nx=x+dir[0], ny=y+dir[1];

            if (nx<0 || nx>=m || ny<0 || ny>=n) continue;

            int effort=Math.abs(heights[x][y]-heights[nx][ny]);
            edges.add(new int[]{nx, ny, effort});
        }
        return edges;
    }
}
