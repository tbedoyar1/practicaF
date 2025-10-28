package Algorithm;
import Graph.*;
import java.util.*;

public class Yen {
    public static List<List<Integer>> kShortestPaths(Graph graph, int source, int target, int k) {
        List<List<Integer>> A = new ArrayList<>();
        List<Path> B = new ArrayList<>();

        List<Integer> shortest = Dijkstra.shortestPath(graph, source, target);
        if (shortest.isEmpty()) return A;
        A.add(shortest);

        for (int i = 1; i < k; i++) {
            List<Integer> prevPath = A.get(i - 1);
            for (int j = 0; j < prevPath.size() - 1; j++) {
                int spurNode = prevPath.get(j);
                List<Integer> rootPath = prevPath.subList(0, j + 1);

                Graph tempGraph = cloneGraphWithoutRootEdges(graph, A, rootPath);
                List<Integer> spurPath = Dijkstra.shortestPath(tempGraph, spurNode, target);

                if (!spurPath.isEmpty()) {
                    List<Integer> totalPath = new ArrayList<>(rootPath);
                    totalPath.addAll(spurPath.subList(1, spurPath.size()));
                    double cost = calculateCost(graph, totalPath);
                    B.add(new Path(totalPath, cost));
                }
            }

            if (B.isEmpty()) break;
            B.sort(Comparator.comparingDouble(p -> p.cost));
            A.add(B.remove(0).nodes);
        }
        return A;
    }

    private static double calculateCost(Graph g, List<Integer> path) {
        double cost = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            for (Edge e : g.getNeighbors(path.get(i))) {
                if (e.to == path.get(i + 1)) cost += e.weight;
            }
        }
        return cost;
    }

    private static Graph cloneGraphWithoutRootEdges(Graph original, List<List<Integer>> A, List<Integer> root) {
        Graph clone = new Graph(original.size());
        for (int i = 0; i < original.size(); i++) {
            for (Edge e : original.getNeighbors(i)) {
                clone.addEdge(e.from, e.to, e.weight);
            }
        }
        for (List<Integer> path : A) {
            if (path.size() > root.size() && path.subList(0, root.size()).equals(root)) {
                int u = path.get(root.size() - 1);
                int v = path.get(root.size());
                clone.getNeighbors(u).removeIf(edge -> edge.to == v);
            }
        }
        return clone;
    }

    private static class Path {
        List<Integer> nodes;
        double cost;
        Path(List<Integer> n, double c) { nodes = n; cost = c; }
    }
}
