package levelThree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42861">섬 연결하기</a>
 * Category : Greedy, Union-Find, Kruskal, Minimum Spanning Tree, MST
 */
public class ConnectingIslands {

    public static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }

        @Override
        public String toString() {
            return "Edge{" + "u=" + u + ", v=" + v + ", weight=" + weight + '}';
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
            if (parent[x] != x) parent[x] = find(parent[x]);
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

    public int solution(int n, int[][] costs) {
        int answer = 0;
        int count = 0;
        List<Edge> edges = new ArrayList<>();
        for (int[] cost : costs) edges.add(new Edge(cost[0], cost[1], cost[2]));
        Collections.sort(edges);
        UnionFind uf = new UnionFind(n);
        for (Edge edge : edges) {
            if (uf.union(edge.u, edge.v)) {
                answer += edge.weight;
                count++;
                if (count == n - 1) break;
            }
        }
        return answer;
    }
}
