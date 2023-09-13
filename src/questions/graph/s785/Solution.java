package questions.graph.s785;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    boolean[] visited, color;
    boolean isBipartite=true;

    public boolean isBipartiteDFS(int[][] graph) {
        int len=graph.length;
        visited=new boolean[len];
        color=new boolean[len];

        for (int v=0; v<len; v++) {
            traverse(graph, v);
        }

        return isBipartite;
    }

    void traverse(int[][] graph, int s) {
        if (!isBipartite) return;
        visited[s]=true;

        for (int v : graph[s]) {
            if (!visited[v]) {
                color[v]=!color[s];
                traverse(graph, v);
            } else {
                if (color[v]==color[s]) {
                    isBipartite=false;
                    return;
                }
            }
        }
    }

    public boolean isBipartiteBFS(int[][] graph) {
        int len=graph.length;
        visited=new boolean[len];
        color=new boolean[len];

        for (int v=0; v<len; v++) bfs(graph, v);

        return isBipartite;
    }

    void bfs(int[][] graph, int start) {
        Queue<Integer> q=new LinkedList<>();
        visited[start]=true;
        q.offer(start);

        while (!q.isEmpty()&&isBipartite) {
            int v=q.poll();

            for (int s : graph[v]) {
                if (!visited[s]) {
                    color[s]=!color[v];
                    visited[s]=true;
                    q.offer(s);
                } else {
                    if (color[s]==color[v]) {
                        isBipartite=false;
                        return;
                    }
                }
            }
        }
    }
}
