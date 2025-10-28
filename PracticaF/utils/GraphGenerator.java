package utils;
import Graph.*;
import java.util.*;

public class GraphGenerator {
    public static Graph generateRandomGraph(int n, double p) {
        Random rand = new Random();
        Graph g = new Graph(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && rand.nextDouble() < p) {
                    double weight = 1 + rand.nextInt(9);
                    g.addEdge(i, j, weight);
                }
            }
        }
        return g;
    }
}
