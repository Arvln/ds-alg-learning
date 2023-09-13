package questions.graph.s133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Solution {
    private HashMap<Node, Node> visited;
    public Node cloneGraph(Node node) {
        visited=new HashMap<>();
        return build(node);
    }

    Node build(Node node) {
        if (node==null) return null;
        if (visited.containsKey(node)) return visited.get(node);

        Node cur=new Node(node.val);
        visited.put(node, cur);

        for (Node neighbor : node.neighbors) {
            cur.neighbors.add(build(neighbor));
        }
        return cur;
    }
}
