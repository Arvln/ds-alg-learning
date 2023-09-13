package questions.graph.s1514;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = buildGraph(n, edges, succProb);
        return dijkstra(start, end, graph);
    }

    static class Point {
        int id;
        double probFromStart;

        public Point(int id, double probFromStart) {
            this.id = id;
            this.probFromStart = probFromStart;
        }
    }

    double dijkstra(int start, int end, List<double[]>[] graph) {
        double[] probTo=new double[graph.length];
        Arrays.fill(probTo, -1);
        probTo[start]=1;
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probFromStart, a.probFromStart));
        pq.offer(new Point(start, 1));

        while (!pq.isEmpty()) {
            Point cur=pq.poll();
            int id=cur.id;
            double probFromStart=cur.probFromStart;

            if (id==end) return probFromStart;
            if (probFromStart<probTo[id]) continue;

            for (double[] next : graph[id]) {
                int nextID=(int)next[0];
                double nextProbFromStart=probTo[id]*next[1];

                if (probTo[nextID]<nextProbFromStart) {
                    probTo[nextID]=nextProbFromStart;
                    pq.offer(new Point(nextID, nextProbFromStart));
                }
            }
        }
        return 0.0f;
    }

    List<double[]>[] buildGraph(int n, int[][] edges, double[] succProb) {
        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) graph[i]=new LinkedList<>();
        for (int i = 0; i < edges.length; i++) {
            int from=edges[i][0], to=edges[i][1];
            double weight=succProb[i];

            graph[from].add(new double[]{(double) to, weight});
            graph[to].add(new double[]{(double) from, weight});
        }
        return graph;
    }
}
