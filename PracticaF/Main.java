import Graph.*;
import Algorithm.*;
import utils.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int nodes = 6;
        Graph g = GraphGenerator.generateRandomGraph(nodes, 0.6);
        System.out.println("=== Random Graph ===");
        System.out.println(g);

        int source = 0;
        int target = nodes - 1;

        int k = 3;
        List<List<Integer>> paths = Yen.kShortestPaths(g, source, target, k);

        System.out.println("\nK shortest paths from " + source + " to " + target + ":");
        if (paths.isEmpty()) {
            System.out.println("No path found between nodes " + source + " and " + target);
        } else {
            for (int i = 0; i < paths.size(); i++) {
                System.out.println("Path " + (i + 1) + ": " + paths.get(i));
            }
        }
    }
}
