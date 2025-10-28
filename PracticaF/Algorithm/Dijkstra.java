package Algorithm;
import Graph.*;
import java.util.*;

public class Dijkstra {
    public static List<Integer> shortestPath(Graph graph, int source, int target) {
        double[] dist = new double[graph.size()];
        int[] prev = new int[graph.size()];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        Arrays.fill(prev, -1);
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[1]));
        pq.add(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            if (u == target) break;

            for (Edge edge : graph.getNeighbors(u)) {
                int v = edge.to;
                double alt = dist[u] + edge.weight;
                if (alt < dist[v]) {
                    dist[v] = alt;
                    prev[v] = u;
                    pq.add(new int[]{v, (int) alt});
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        for (int at = target; at != -1; at = prev[at]) {
            path.add(0, at);
        }
        if (path.size() == 1 && path.get(0) != source) return new ArrayList<>();
        return path;
    }
}
