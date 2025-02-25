package greedy;

import java.util.*;

public class Kruskal {

    public static class Edge implements Comparable<Edge> {
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    public static class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // 경로 압축
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;
            parent[rootY] = rootX;
            return true;
        }
    }

    public int minimumSpanningTree(int n, List<Edge> edges) {
        int result = 0;
        Collections.sort(edges);
        UnionFind uf = new UnionFind(n);
        int mstWeight = 0;
        for (Edge edge : edges) {
            if (uf.union(edge.u, edge.v)) {
                mstWeight += edge.weight;
                result++;
                if (result == n - 1) break;
            }
        }
        return mstWeight;
    }
}
