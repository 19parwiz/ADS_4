import java.util.List;  // Import statement for List

public interface Search<V> {
    List<V> search(WeightedGraph<V> graph, V start);
}
