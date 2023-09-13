package practices.graph.s743;

import java.util.*;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph=buildGraph(times, n);
        int[] wTo=new int[n+1];
        Arrays.fill(wTo, Integer.MAX_VALUE);
        wTo[k]=0;

        Queue<Point> pq=new PriorityQueue<>((a, b)->a.wFromStart-b.wFromStart);
        pq.offer(new Point(k, 0));

        while(!pq.isEmpty()) {
            Point cur=pq.poll();
            int id=cur.id, wFromStart=cur.wFromStart;

            if (wTo[id]<wFromStart) continue;
            for (int[] next : graph[id]) {
                int nextId=next[0], nextWFromStart=wFromStart+next[1];

                if (wTo[nextId]>nextWFromStart) {
                    wTo[nextId]=nextWFromStart;
                    pq.offer(new Point(nextId, nextWFromStart));
                }
            }
        }

        int res=0;
        for (int i=1; i<wTo.length; i++) {
            if (wTo[i]==Integer.MAX_VALUE) return -1;
            res=Math.max(res, wTo[i]);
        }
        return res;
    }

    static class Point {
        int id, wFromStart;
        public Point(int id, int wFromStart) {
            this.id=id;
            this.wFromStart=wFromStart;
        }
    }

    List<int[]>[] buildGraph(int[][] times, int n) {
        List<int[]>[] graph=new LinkedList[n+1];
        for (int i=1; i<=n; i++) graph[i]=new LinkedList<>();
        for (int[] time : times) {
            int from=time[0], to=time[1], w=time[2];

            graph[from].add(new int[]{to, w});
        }
        return graph;
    }
}
