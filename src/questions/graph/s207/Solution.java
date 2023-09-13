package questions.graph.s207;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    boolean[] visited, onPath;
    boolean hasCircle;
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited=new boolean[numCourses];
        onPath=new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCircle;
    }

    void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) hasCircle=true;
        if (visited[s]||hasCircle) return;

        visited[s]=true;
        onPath[s]=true;

        for (Integer v : graph[s]) {
            traverse(graph, v);
        }

        onPath[s]=false;
    }

    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph=new LinkedList[numCourses];

        for (int i=0; i<numCourses; i++) {
            graph[i]=new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from=prerequisite[1], to=prerequisite[0];

            graph[from].add(to);
        }

        return graph;
    }

    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph=buildGraph(numCourses, prerequisites);
        int[] indegree=new int[numCourses];

        for (int[] prerequisite: prerequisites) {
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> q=new LinkedList<>();

        for (int i=0; i<numCourses; i++) {
            if (indegree[i]==0) q.offer(i);
        }

        int count=0;
        while(!q.isEmpty()) {
            int s=q.poll();
            count++;

            for (Integer v : graph[s]) {
                indegree[v]--;
                if (indegree[v]==0) q.offer(v);
            }
        }

        return count==numCourses;
    }
}
