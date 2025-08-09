package p1238;

import java.util.*;

/**
 * 제목 : 파티 - Bidirectional Dijkstra's Algorithm
 * 링크 : https://www.acmicpc.net/problem/1238
 * 분류 : 그래프 이론, 최단 경로, 다익스트라
 * 난이도 : Gold III
 * 
 * ========================================================================
 * ■ 문제 개요 및 핵심 개념
 * ========================================================================
 * 
 * N명의 학생이 각자 다른 마을에 살고 있고, X번 마을에서 파티가 열립니다.
 * 모든 학생은 자신의 마을에서 X번 마을로 가서 파티에 참석한 후, 
 * 다시 자신의 마을로 돌아가야 합니다. 왕복 시간이 가장 긴 학생의 시간을 구하는 문제입니다.
 * 
 * ★ 핵심 아이디어:
 * - 각 마을에서 X로 가는 최단 경로 + X에서 각 마을로 가는 최단 경로
 * - 방향 그래프이므로 정방향과 역방향을 모두 고려해야 함
 * - 다익스트라 알고리즘을 2번 실행하거나, 그래프를 뒤집어서 활용
 * 
 * ★ 해결 방법:
 * 1) X에서 모든 정점으로의 최단 경로 (다익스트라 1회)
 * 2) 모든 정점에서 X로의 최단 경로 → 역방향 그래프에서 X에서 모든 정점으로의 최단 경로
 * 
 * 시간복잡도: O((V+E)logV) × 2 = O((V+E)logV)
 * 공간복잡도: O(V+E)
 */
public class Main {
    
    static class Edge implements Comparable<Edge> {
        int to, cost;
        
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 학생 수 (마을 수)
        int M = sc.nextInt(); // 도로 수
        int X = sc.nextInt(); // 파티 장소
        
        List<List<Edge>> graph = new ArrayList<>();
        List<List<Edge>> reverseGraph = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            
            graph.get(from).add(new Edge(to, cost));
            reverseGraph.get(to).add(new Edge(from, cost)); // 역방향 그래프
        }
        
        // X에서 모든 정점으로의 최단 거리 (돌아가는 경로)
        int[] distFromX = dijkstra(graph, N, X);
        
        // 모든 정점에서 X로의 최단 거리 (가는 경로) = 역방향 그래프에서 X에서의 최단 거리
        int[] distToX = dijkstra(reverseGraph, N, X);
        
        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            if (i != X) {
                int roundTrip = distToX[i] + distFromX[i];
                maxTime = Math.max(maxTime, roundTrip);
            }
        }
        
        System.out.println(maxTime);
    }
    
    private static int[] dijkstra(List<List<Edge>> graph, int n, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.to;
            int currentCost = current.cost;
            
            if (currentCost > dist[currentNode]) continue;
            
            for (Edge next : graph.get(currentNode)) {
                int nextNode = next.to;
                int nextCost = currentCost + next.cost;
                
                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new Edge(nextNode, nextCost));
                }
            }
        }
        
        return dist;
    }
}