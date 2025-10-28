package Graph;

public class Edge {
    public int from;
    public int to;
    public double weight;

    public Edge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + from + " → " + to + ", w=" + weight + ")";
    }
}
