package graph;

public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;


    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == w) {
            return v;
        } else {
            return w;
        }
    }

    @Override
    public int compareTo(Edge e) {
        return Double.compare(weight(), e.weight());
    }
}
