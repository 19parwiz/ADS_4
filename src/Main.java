import java.util.Scanner;
import java.util.Map;

public class Main {
    private static final String DISTANCE_UNIT = "kilometers";

    public static void main(String[] args) {
        MyGraph<String> graph = new MyGraph<>();  // Using MyGraph which can extend WeightedGraph
        setupGraph(graph);  // Set up the graph with distances in kilometers
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the source city (or type 'exit' to quit):");
            String source = scanner.nextLine().trim();
            if (source.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter the destination city:");
            String destination = scanner.nextLine().trim();
            if (destination.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Do you want the 'shortest', 'longest', or 'DFS path'?");
            String pathType = scanner.nextLine().trim().toLowerCase();
            if (pathType.equals("exit")) {
                break;
            }

            switch (pathType) {
                case "shortest":
                    DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
                    Map<String, Double> distances = dijkstra.search(graph, source);
                    Double distance = distances.get(destination);
                    if (distance != null) {
                        System.out.printf("Shortest distance from %s to %s is %.2f %s.\n", source, destination, distance, DISTANCE_UNIT);
                    } else {
                        System.out.println("One or both cities not found.");
                    }
                    break;
                case "longest":
                    System.out.println("Longest path functionality not implemented.");
                    break;
                case "dfs path":
                    DepthFirstSearch<String> dfs = new DepthFirstSearch<>();
                    System.out.println("DFS path from " + source + ": " + dfs.search(graph, source));
                    break;
                default:
                    System.out.println("Invalid option. Please enter 'shortest', 'longest', or 'DFS path'.");
                    break;
            }
            System.out.println("\n--- Next Query ---\n");
        }

        scanner.close();
        System.out.println("Program terminated.");
    }

    private static void setupGraph(MyGraph<String> graph) {
        // Add all mentioned cities as vertices
        String[] cities = {"Kabul", "Tehran", "Dushanbe", "Astana", "Baku", "Beijing", "Tokyo", "Moscow", "Ankara", "New Delhi", "Tashkent", "Dubai", "Riyadh"};
        for (String city : cities) {
            graph.addVertex(city);
        }

        // Add edges with more distances (in kilometers)
        graph.addEdge("Kabul", "Tehran", 990);
        graph.addEdge("Tehran", "Ankara", 1760);
        graph.addEdge("Dushanbe", "Tashkent", 576);
        graph.addEdge("Astana", "Moscow", 2250);
        graph.addEdge("Baku", "Moscow", 1700);
        graph.addEdge("Beijing", "Tokyo", 2100);
        graph.addEdge("New Delhi", "Beijing", 3800);
        graph.addEdge("Tashkent", "Moscow", 2200);
        graph.addEdge("Dubai", "Riyadh", 872);
        graph.addEdge("Riyadh", "Ankara", 2200);
        graph.addEdge("Dubai", "New Delhi", 2200);
        graph.addEdge("Moscow", "Tokyo", 7500);
    }
}
