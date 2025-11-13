package graph;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int vertexCount = 5;

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 2));
        edges.add(new Edge(1, 2, 5));
        edges.add(new Edge(1, 3, 10));
        edges.add(new Edge(2, 4, 3));
        edges.add(new Edge(4, 3, 4));

        List<Edge> mst = KruskalMST.build(vertexCount, edges);

        System.out.println("MST edges (before removal):");
        for (Edge e : mst) {
            System.out.println(e);
        }
    }
}
