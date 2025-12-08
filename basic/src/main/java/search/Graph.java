package search;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final int n;
    private final List<List<Integer>> adj;

    public Graph(int n) {
        this.n = n;
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public List<Integer> getNeighbors(int u) {
        return adj.get(u);
    }

    public int getSize() {
        return n;
    }
}
