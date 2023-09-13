package questions.graph.s743;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = buildGraph(n, times);
        int[] distTo = dijkstra(k, graph);

        int res=0;
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i]==Integer.MAX_VALUE) return -1;
            res=Math.max(res, distTo[i]);
        }
        return res;
    }

    static class Point {
        int id, distFromStart;
        public Point(int id, int distFromStart) {
            this.id=id;
            this.distFromStart=distFromStart;
        }
    }

    int[] dijkstra(int start, List<int[]>[] graph) {
        int[] distTo=new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start]=0;

        PriorityQueue<Point> pq = new PriorityQueue<>((a, b)->a.distFromStart-b.distFromStart);
        pq.offer(new Point(start, 0));

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            int curId=cur.id, curDistFromStart=cur.distFromStart;

            if (curDistFromStart>distTo[curId]) continue;

            for (int[] next : graph[curId]) {
                int nextId=next[0], nextDist=curDistFromStart+next[1];

                if (distTo[nextId]>nextDist) {
                    distTo[nextId]=nextDist;
                    pq.offer(new Point(nextId, nextDist));
                }
            }
        }
        return distTo;
    }

    List<int[]>[] buildGraph(int n, int[][] times) {
        LinkedList<int[]>[] graph = new LinkedList[n + 1];

        for (int i = 1; i <= n; i++) graph[i]=new LinkedList<>();
        for (int[] time : times) {
            int from=time[0], to=time[1], weight=time[2];

            graph[from].add(new int[]{to, weight});
        }

        return graph;
    }
}
