public class Main {
    public static void main(String[] args) {
        MyGraph<String> graph = new MyGraph<>();
        setupGraph(graph); // Assume this is already defined as shown previously

        // Demonstrate BFS
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
        System.out.println("BFS result: " + bfs.search(graph, "A"));

        // Demonstrate DFS
        DepthFirstSearch<String> dfs = new DepthFirstSearch<>();
        System.out.println("DFS result: " + dfs.search(graph, "A"));

        // Demonstrate Dijkstra's algorithm
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
        System.out.println("Dijkstra's result: " + dijkstra.search(graph, "A"));
    }
}
