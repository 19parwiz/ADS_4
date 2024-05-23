public class MyGraph<V> extends WeightedGraph<V> {
    // Add any custom methods or attributes here if necessary


    public void removeEdge(V source, V destination) {
        Vertex<V> sourceVertex = getVertex(source);
        Vertex<V> destinationVertex = getVertex(destination);
        if (sourceVertex != null && destinationVertex != null) {
            sourceVertex.getAdjacentVertices().remove(destinationVertex);
        }
    }
}
