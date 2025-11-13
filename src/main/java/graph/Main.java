package graph;

import java.util.*;

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

        int removeIndex = 1;
        Edge removed = mst.remove(removeIndex);

        System.out.println("\nRemoved edge: " + removed);
        System.out.println("\nMST edges (after removal):");
        for (Edge e : mst) {
            System.out.println(e);
        }

        System.out.println("\nConnected components:");
        List<List<Integer>> components = findComponents(vertexCount, mst);

        int compId = 1;
        for (List<Integer> comp : components) {
            System.out.println("Component " + compId++ + ": " + comp);
        }

        Edge replacement = findReplacementEdge(edges, components);

        System.out.println("\nReplacement edge found: " + replacement);

        mst.add(replacement);

        System.out.println("\n===== FINAL MST AFTER RECONNECTION =====");
        int totalWeight = 0;
        for (Edge e : mst) {
            System.out.println(e);
            totalWeight += e.weight;
        }
        System.out.println("Total MST Weight = " + totalWeight);

    }

    private static List<List<Integer>> findComponents(int vertexCount, List<Edge> mst) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            adj.add(new ArrayList<>());
        }

        for (Edge e : mst) {
            adj.get(e.u).add(e.v);
            adj.get(e.v).add(e.u);
        }

        boolean[] visited = new boolean[vertexCount];
        List<List<Integer>> components = new ArrayList<>();

        for (int start = 0; start < vertexCount; start++) {
            if (!visited[start]) {
                List<Integer> comp = new ArrayList<>();
                Queue<Integer> q = new LinkedList<>();
                q.add(start);
                visited[start] = true;

                while (!q.isEmpty()) {
                    int node = q.poll();
                    comp.add(node);
                    for (int nei : adj.get(node)) {
                        if (!visited[nei]) {
                            visited[nei] = true;
                            q.add(nei);
                        }
                    }
                }

                components.add(comp);
            }
        }

        return components;
    }

    private static Edge findReplacementEdge(List<Edge> allEdges, List<List<Integer>> components) {
        Set<Integer> compA = new HashSet<>(components.get(0));
        Set<Integer> compB = new HashSet<>(components.get(1));

        Edge best = null;

        for (Edge e : allEdges) {
            if ( (compA.contains(e.u) && compB.contains(e.v)) ||
                    (compA.contains(e.v) && compB.contains(e.u)) ) {

                if (best == null || e.weight < best.weight) {
                    best = e;
                }
            }
        }
        return best;
    }
}
