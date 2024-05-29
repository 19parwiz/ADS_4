import java.util.*;

public class Dijkstra<V> {
    public Map<V, Double> dijkstra(WeightedGraph<V> graph, V start) {
        Map<V, Double> distances = new HashMap<>();
        Map<Vertex<V>, Double> distancesForPQ = new HashMap<>();  // Separate map for PriorityQueue
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distancesForPQ::get));
        Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();

        // Initialize distances and distancesForPQ
        for (V vertex : graph.getVertices().keySet()) {
            Vertex<V> v = graph.getVertex(vertex);
            distances.put(vertex, Double.MAX_VALUE);
            distancesForPQ.put(v, Double.MAX_VALUE);
        }
        distances.put(start, 0.0);
        distancesForPQ.put(graph.getVertex(start), 0.0);  //

        Vertex<V> startVertex = graph.getVertex(start);
        priorityQueue.add(startVertex);  // Now safe to add

        while (!priorityQueue.isEmpty()) {
            Vertex<V> current = priorityQueue.poll();
            double currentDistance = distances.get(current.getData());
            if (currentDistance == Double.MAX_VALUE) continue; // Skip if distance is infinity

            for (Map.Entry<Vertex<V>, Double> neighborEntry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();
                double newDist = currentDistance + weight;

                if (newDist < distances.get(neighbor.getData())) {
                    distances.put(neighbor.getData(), newDist);
                    distancesForPQ.put(neighbor, newDist);  // Update distance in separate map
                    previous.put(neighbor, current);
                    priorityQueue.add(neighbor);
                }
            }
        }
        return distances;
    }
}
