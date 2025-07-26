package p1197;

import java.util.*;

/**
 * 제목 : 최소 스패닝 트리
 * 링크 : https://www.acmicpc.net/problem/1197
 * 분류 : 최소 스패닝 트리, 그래프, 크루스칼, 프림
 * 
 * === 문제 해설 ===
 * 주어진 그래프에서 모든 정점을 연결하는 최소 비용의 스패닝 트리를 구하는 문제입니다.
 * 
 * === 수학적/이론적 배경 ===
 * 1) 스패닝 트리(Spanning Tree)의 정의:
 *    - 그래프의 모든 정점을 포함하는 연결된 부분 그래프
 *    - N개의 정점을 가진 그래프의 스패닝 트리는 정확히 N-1개의 간선을 가짐
 *    - 사이클이 없는 트리 구조
 * 
 * 2) 최소 스패닝 트리(MST)의 특성:
 *    - 모든 정점을 연결하는 스패닝 트리 중 간선 가중치의 합이 최소인 트리
 *    - 유일하지 않을 수 있음 (같은 최소 비용의 여러 MST 존재 가능)
 *    - 컷 성질(Cut Property): 임의의 컷에서 최소 가중치 간선은 MST에 포함
 *    - 사이클 성질(Cycle Property): 임의의 사이클에서 최대 가중치 간선은 MST에 포함되지 않음
 * 
 * 3) 탐욕 알고리즘의 적용:
 *    - MST 문제는 탐욕 알고리즘으로 최적해를 구할 수 있는 대표적인 문제
 *    - 매트로이드(Matroid) 이론의 적용 사례
 *    - 국소 최적해가 전역 최적해가 되는 구조
 * 
 * === 알고리즘 설계 ===
 * 1) 크루스칼 알고리즘 (Kruskal's Algorithm):
 *    - 간선 중심의 접근법
 *    - 모든 간선을 가중치 순으로 정렬
 *    - 가중치가 작은 간선부터 선택하되, 사이클을 형성하지 않는 간선만 선택
 *    - Union-Find 자료구조를 사용하여 사이클 검사
 * 
 * 2) 프림 알고리즘 (Prim's Algorithm):
 *    - 정점 중심의 접근법  
 *    - 임의의 정점에서 시작하여 트리를 확장
 *    - 현재 트리와 연결된 간선 중 최소 가중치 간선을 선택
 *    - 우선순위 큐를 사용하여 효율적 구현
 * 
 * === 구현 세부사항 ===
 * 1) 크루스칼 알고리즘 구현:
 *    - Edge 클래스: 간선 정보 (출발점, 도착점, 가중치)
 *    - Comparable 인터페이스로 가중치 기준 정렬
 *    - Union-Find: 경로 압축 + 랭크 기반 합집합
 *    - 시간복잡도: O(E log E) - 간선 정렬이 지배적
 * 
 * 2) Union-Find 최적화:
 *    - 경로 압축(Path Compression): find 연산을 O(α(n))으로 단축
 *    - 랭크 기반 합집합(Union by Rank): 트리 높이를 최소화
 *    - α(n): 아커만 함수의 역함수 (실질적으로 상수)
 * 
 * 3) 메모리 효율성:
 *    - 인접 리스트 대신 간선 리스트 사용
 *    - 정점 번호를 0-based 인덱스로 변환하여 배열 접근 최적화
 * 
 * === 시간/공간 복잡도 ===
 * - 크루스칼: 시간 O(E log E), 공간 O(V + E)
 * - 프림: 시간 O(E log V) (우선순위 큐 사용), 공간 O(V + E)
 * - 조밀한 그래프(E ≈ V²): 프림이 유리
 * - 희소한 그래프(E ≈ V): 크루스칼이 유리
 * 
 * === 고급 최적화 기법 ===
 * 1) 보르우프카 알고리즘 (Borůvka's Algorithm):
 *    - 병렬 처리에 적합한 O(E log V) 알고리즘
 *    - 각 연결 성분에서 최소 간선을 동시에 선택
 * 
 * 2) 프림 알고리즘의 피보나치 힙 최적화:
 *    - 시간복잡도를 O(E + V log V)로 개선
 *    - decrease-key 연산이 O(1) 분할상환 시간
 * 
 * 3) 동적 MST:
 *    - 간선 추가/삭제에 대한 MST 동적 유지
 *    - Link-Cut Tree를 이용한 O(log² n) 갱신
 * 
 * === 실전 코딩테스트 대비 포인트 ===
 * 1) 구현 선택 기준:
 *    - 간선 수가 적으면 크루스칼 (구현이 더 간단)
 *    - 정점 수가 적고 조밀한 그래프면 프림
 *    - 대부분의 경우 크루스칼이 무난한 선택
 * 
 * 2) 주의사항:
 *    - 그래프가 연결되어 있지 않은 경우 처리
 *    - 간선 가중치의 자료형 (int vs long)
 *    - Union-Find에서 부모 배열 초기화
 * 
 * 3) 변형 문제들:
 *    - 최대 스패닝 트리: 가중치를 음수로 변환
 *    - k번째 최소 스패닝 트리
 *    - 제약 조건이 있는 MST
 * 
 * === 관련 알고리즘 패러다임 ===
 * 1) 탐욕 알고리즘:
 *    - 다익스트라 최단경로 알고리즘
 *    - 허프만 코딩
 *    - 활동 선택 문제
 * 
 * 2) 그래프 이론:
 *    - 최단경로 문제
 *    - 네트워크 플로우
 *    - 강연결 성분
 * 
 * 3) 자료구조 응용:
 *    - Union-Find (서로소 집합)
 *    - 우선순위 큐 (힙)
 *    - 그래프 표현 방식
 * 
 * === 실제 응용 사례 ===
 * 1) 네트워크 설계:
 *    - 통신망 구축 최소 비용
 *    - 전력망 설계
 *    - 도로망 계획
 * 
 * 2) 클러스터링:
 *    - 단일 연결 클러스터링
 *    - 이미지 분할
 *    - 데이터 마이닝
 * 
 * 3) 근사 알고리즘:
 *    - TSP 2-근사 알고리즘
 *    - 스타이너 트리 근사
 */
public class Main {
    
    static class Edge implements Comparable<Edge> {
        int u, v, weight;
        
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    
    static class UnionFind {
        int[] parent, rank;
        
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // 경로 압축
            }
            return parent[x];
        }
        
        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX == rootY) return false; // 이미 같은 집합
            
            // 랭크 기반 합집합
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // 정점 개수
        int E = sc.nextInt(); // 간선 개수
        
        List<Edge> edges = new ArrayList<>();
        
        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt() - 1; // 0-based 인덱스로 변환
            int v = sc.nextInt() - 1;
            int weight = sc.nextInt();
            edges.add(new Edge(u, v, weight));
        }
        
        // 크루스칼 알고리즘 수행
        long mstWeight = kruskal(V, edges);
        System.out.println(mstWeight);
    }
    
    /**
     * 크루스칼 알고리즘으로 최소 스패닝 트리의 가중치 합을 구함
     * 
     * @param V 정점 개수
     * @param edges 간선 리스트
     * @return MST의 총 가중치
     */
    static long kruskal(int V, List<Edge> edges) {
        // 1. 간선들을 가중치 기준으로 정렬
        Collections.sort(edges);
        
        // 2. Union-Find 초기화
        UnionFind uf = new UnionFind(V);
        
        long totalWeight = 0;
        int edgeCount = 0;
        
        // 3. 간선을 하나씩 검사하며 MST 구성
        for (Edge edge : edges) {
            // 사이클을 형성하지 않는 간선이면 선택
            if (uf.union(edge.u, edge.v)) {
                totalWeight += edge.weight;
                edgeCount++;
                
                // MST는 정확히 V-1개의 간선을 가짐
                if (edgeCount == V - 1) {
                    break;
                }
            }
        }
        
        return totalWeight;
    }
}