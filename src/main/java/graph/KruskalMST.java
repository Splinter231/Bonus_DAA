package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalMST {

    public static List<Edge> build(int vertexCount, List<Edge> edges) {

        edges.sort(Comparator.comparingInt(e -> e.weight));

        UnionFind uf = new UnionFind(vertexCount);
        List<Edge> mst = new ArrayList<>();

        for (Edge e : edges) {
            if (uf.union(e.u, e.v)) {
                mst.add(e);
            }
        }

        return mst;
    }
}
