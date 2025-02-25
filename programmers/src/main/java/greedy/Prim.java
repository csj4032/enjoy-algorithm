package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {

    public static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }

        @Override
        public String toString() {
            return "Node{" + "vertex=" + vertex + ", weight=" + weight + '}';
        }
    }

    public int minimumSpanningTree(int n, int[][] edges) {
        List<List<Node>> graph = addEdge(n, edges);
        int result = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.vertex]) continue;
            visited[node.vertex] = true;
            result += node.weight;
            for (Node adj : graph.get(node.vertex)) {
                if (!visited[adj.vertex]) {
                    pq.offer(adj);
                }
            }
        }
        return result;
    }

    private List<List<Node>> addEdge(int n, int[][] edges) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            graph.get(u).add(new Node(v, weight));
            graph.get(v).add(new Node(u, weight));
        }
        return graph;
    }
}
