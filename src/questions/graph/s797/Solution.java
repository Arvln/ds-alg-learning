package questions.graph.s797;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res=new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        traverse(graph, 0, new LinkedList<>());
        return res;
    }

    void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        path.add(s);

        if (s==graph.length-1) res.add(new LinkedList<>(path));

        for (int n : graph[s]) traverse(graph, n, path);
        path.removeLast();
    }
}
