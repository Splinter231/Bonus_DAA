package graph;

public class Edge {
    public int u;
    public int v;
    public int weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "(" + u + " - " + v + ", w=" + weight + ")";
    }
}
