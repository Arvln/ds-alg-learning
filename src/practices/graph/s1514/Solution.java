package practices.graph.s1514;

import java.util.*;

public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<double[]>[] graph=buildGraph(n, edges, succProb);
        double[] probTo=new double[n];
        Arrays.fill(probTo, -1);
        probTo[start_node]=1;

        Queue<double[]> pq=new PriorityQueue<>((a, b)->Double.compare(b[1], a[1]));
        pq.offer(new double[]{start_node, 1});
        while(!pq.isEmpty()) {
            double[] cur=pq.poll();
            int id=(int)cur[0];
            double prob=cur[1];

            if (id==end_node) return prob;
            if (prob<probTo[id]) continue;

            for (double[] next: graph[id]) {
                int nextId=(int)next[0];
                double nextProb=prob*next[1];

                if (probTo[nextId]<nextProb) {
                    probTo[nextId]=nextProb;
                    pq.offer(new double[]{(double)nextId, nextProb});
                }
            }
        }
        return 0.0f;
    }

    List<double[]>[] buildGraph(int n, int[][] edges, double[] succProb) {
        List<double[]>[] graph=new LinkedList[n];
        for(int i=0; i<n; i++) graph[i]=new LinkedList<>();
        for(int i=0; i<edges.length; i++) {
            int from=edges[i][0], to=edges[i][1];
            double prob=succProb[i];

            graph[from].add(new double[]{(double)to, prob});
            graph[to].add(new double[]{(double)from, prob});
        }
        return graph;
    }
}
