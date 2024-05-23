import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    public Map<V, Double> search(WeightedGraph<V> graph, V start) {
        Map<V, Double> distances = new HashMap<>();
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        distances.put(start, 0.0);

        Vertex<V> startVertex = graph.getVertex(start);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double newDist = distances.get(current.getData()) + entry.getValue();
                if (newDist < distances.getOrDefault(neighbor.getData(), Double.MAX_VALUE)) {
                    distances.put(neighbor.getData(), newDist);
                    queue.add(neighbor);
                }
            }
        }
        return distances;
    }
}
