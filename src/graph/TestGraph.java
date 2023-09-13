package graph;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestGraph {
    @Test
    public void testDFS() {
        Graph graph = new Graph(13);

        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(4, 3);
        graph.addEdge(4, 6);

        graph.addEdge(7, 8);

        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        DFS dfs = new DFS(graph, 0);

        assertEquals(7, dfs.count());
        assertTrue(dfs.marked(5));
        assertFalse(dfs.marked(7));
    }

    @Test
    public void testBFS() {
        Graph graph = new Graph(13);

        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(4, 3);
        graph.addEdge(4, 6);

        graph.addEdge(7, 8);

        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        BFS bfs = new BFS(graph, 0);

        assertEquals(7, bfs.count());
        assertTrue(bfs.marked(5));
        assertFalse(bfs.marked(7));
    }

    @Test
    public void testPathTracking() {
        Graph graph = new Graph(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        graph.addEdge(6, 7);

        PathTracking pathTracking = new PathTracking(graph, 0);

        assertFalse(pathTracking.hasPathTo(7));

        for (Integer v : pathTracking.pathTo(5)) {
            System.out.println(v);
        }
    }

    @Test
    public void testTopoSort() {
        Digraph digraph = new Digraph(6);

        digraph.addEdge(0, 2);
        digraph.addEdge(0, 3);
        digraph.addEdge(2, 4);
        digraph.addEdge(3, 4);
        digraph.addEdge(4, 5);
        digraph.addEdge(1, 3);

        TopoSort topoSort = new TopoSort(digraph);

        assertIterableEquals(Arrays.asList(1, 0, 3, 2, 4, 5), topoSort.order());
    }
}
