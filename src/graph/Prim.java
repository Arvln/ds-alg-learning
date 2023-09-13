package graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {
   private PriorityQueue<int []> pq;
   private boolean[] inMST;
   private int weightSum;
   private List<int []>[] graph;

   public Prim(List<int[]>[] graph) {
       this.graph = graph;
       pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
       int n = graph.length;
       inMST = new boolean[n];

       inMST[0] = true;
       cut(0);

       while (!pq.isEmpty()) {
           int[] edge = pq.poll();
           int to = edge[1];
           int weight = edge[2];

           if (inMST[to]) continue;

           weightSum += weight;
           inMST[to] = true;
           cut(to);
       }
   }

   private void cut(int v) {
       for (int[] edge : graph[v]) {
           int to = edge[0];

           if (inMST[to]) continue;

           pq.offer(edge);
       }
   }

    public int weightSum() {
        return weightSum;
    }

    public boolean allConnected() {
        for (int i = 0; i < inMST.length; i++) {
            if (!inMST[i]) {
                return false;
            }
        }
        return true;
    }
}
