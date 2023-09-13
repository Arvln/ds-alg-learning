package graph;

import stack.LinkedListStack;

public class TopoSort {
    private LinkedListStack<Integer> order;

    public TopoSort(Digraph g) {
        DirectedCycle directedCycle = new DirectedCycle(g);

        if (directedCycle.hasCycle()) return;

        order = new Order(g).reversePost();
    }

    public boolean isCircle() {
        return order == null;
    }

    public LinkedListStack<Integer> order() {
        return order;
    }
}
