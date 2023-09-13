package questions.graph.s1631;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    int[][] dirs=new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    List<int[]> adj(int[][] matrix, int x, int y) {
        int m=matrix.length, n=matrix[0].length;

        List<int[]> neighbors = new LinkedList<>();
        for (int[] dir : dirs) {
            int nx=x+dir[0], ny=y+dir[1];

            if (nx>=m || nx<0 || ny>=n || ny<0) continue;

            neighbors.add(new int[]{nx, ny});
        }

        return neighbors;
    }

    static class Point {
        int x, y, effortFromStart;

        public Point(int x, int y, int effortFromStart) {
            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m=heights.length, n=heights[0].length;
        int[][] effortTo=new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        effortTo[0][0]=0;
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.effortFromStart - b.effortFromStart);
        pq.offer(new Point(0, 0, 0));
        
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            int x=cur.x, y=cur.y, effortFromStart=cur.effortFromStart;

            if (x==m-1&&y==n-1) return effortFromStart;
            if (effortFromStart>effortTo[x][y]) continue;

            for (int[] next : adj(effortTo, x, y)) {
                int nextX=next[0], nextY=next[1];
                int nextEffortFromStart=Math.max(effortTo[x][y], Math.abs(heights[x][y]-heights[nextX][nextY]));

                if (effortTo[nextX][nextY]>nextEffortFromStart) {
                    effortTo[nextX][nextY]=nextEffortFromStart;
                    pq.offer(new Point(nextX, nextY, nextEffortFromStart));
                }
            }
        }

        return -1;
    }
}
