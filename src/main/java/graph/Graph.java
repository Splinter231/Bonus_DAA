package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int vertices;
    private final List<Edge> edges;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    public int getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(int u, int v, int weight) {
        edges.add(new Edge(u, v, weight));
    }

    @Override
    public String toString() {
        return "Graph{V=" + vertices + ", edges=" + edges + "}";
    }
}
