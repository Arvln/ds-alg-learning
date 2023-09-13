package questions.graph.s886;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    boolean[] visited, color;
    boolean res=true;

    public boolean possibleBipartitionDFS(int n, int[][] dislikes) {
        List<Integer>[] graph=buildGraph(n, dislikes);
        visited=new boolean[n+1];
        color=new boolean[n+1];

        for (int v=1; v<=n; v++) traverse(graph, v);

        return res;
    }

    List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] graph=new LinkedList[n+1];

        for (int i=1; i<=n; i++) graph[i]=new LinkedList<>();

        for (int[] edge : dislikes) {
            int a=edge[0], b=edge[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        return graph;
    }

    void traverse(List<Integer>[] graph, int s) {
        visited[s]=true;

        for (int v : graph[s]) {
            if (!visited[v]) {
                color[v]=!color[s];
                traverse(graph, v);
            } else {
                if (color[v]==color[s]) {
                    res=false;
                    return;
                }
            }
        }
    }

    public boolean possibleBipartitionBFS(int n, int[][] dislikes) {
        List<Integer>[] graph=buildGraph(n, dislikes);
        visited=new boolean[n+1];
        color=new boolean[n+1];

        for (int v=1; v<=n; v++) bfs(graph, v);

        return res;
    }

    void bfs(List<Integer>[] graph, int start) {
        Queue<Integer> q=new LinkedList<>();
        visited[start]=true;
        q.offer(start);

        while (!q.isEmpty() && res) {
            int s=q.poll();

            for (Integer v : graph[s]) {
                if (!visited[v]) {
                    visited[v]=true;
                    color[v]=!color[s];
                    q.offer(v);
                } else {
                    if (color[v]==color[s]) {
                        res=false;
                        return;
                    }
                }
            }
        }
    }
}
