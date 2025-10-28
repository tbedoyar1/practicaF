package Graph;
import java.util.*;

public class Graph {
    private int numNodes;
    private Map<Integer, List<Edge>> adjacencyList;

    public Graph(int numNodes) {
        this.numNodes = numNodes;
        adjacencyList = new HashMap<>();
        for (int i = 0; i < numNodes; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int from, int to, double weight) {
        adjacencyList.get(from).add(new Edge(from, to, weight));
    }

    public List<Edge> getNeighbors(int node) {
        return adjacencyList.get(node);
    }

    public int size() {
        return numNodes;
    }

    public Map<Integer, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int node : adjacencyList.keySet()) {
            sb.append(node).append(" → ").append(adjacencyList.get(node)).append("\n");
        }
        return sb.toString();
    }
}
