package p1647;

import java.util.*;

/**
 * 제목 : 도시 분할 계획
 * 링크 : https://www.acmicpc.net/problem/1647
 * 분류 : 최소 스패닝 트리, 그래프, 크루스칼
 * 
 * === 문제 해설 ===
 * N개의 집이 있는 마을을 두 개의 분리된 마을로 분할하되, 
 * 각 마을 안에서는 집들이 서로 연결되어야 하고, 유지비를 최소화하는 문제입니다.
 * 
 * === 핵심 아이디어 ===
 * 1) 문제의 본질:
 *    - 전체 마을에서 MST를 구성한 후
 *    - MST에서 가장 비용이 큰 간선 하나를 제거
 *    - 결과적으로 두 개의 연결된 컴포넌트(마을)가 생성됨
 * 
 * 2) 수학적 증명:
 *    - MST는 N-1개의 간선으로 모든 정점을 연결
 *    - 가장 큰 간선을 제거하면 N-2개 간선으로 두 개의 트리 생성
 *    - 각 트리는 연결되어 있고, 전체 비용이 최소
 * 
 * 3) 최적성 보장:
 *    - MST의 최적성에 의해 N-1개 간선의 합이 최소
 *    - 가장 큰 간선을 제거하는 것이 두 마을 분할에서 최적
 * 
 * === 수학적/이론적 배경 ===
 * 1) MST 분할의 성질:
 *    - MST에서 k개의 간선을 제거하면 k+1개의 연결 성분 생성
 *    - 각 연결 성분은 여전히 트리 구조 유지
 *    - 제거할 간선의 선택에 따라 분할 후 비용이 달라짐
 * 
 * 2) 그리디 선택의 정당성:
 *    - MST에서 가장 큰 간선을 제거하는 것이 최적해
 *    - 다른 간선을 제거할 경우 더 큰 비용이 필요함을 증명 가능
 *    - 컷 성질과 사이클 성질의 확장 적용
 * 
 * 3) 분할 문제의 일반화:
 *    - k개의 마을로 분할: MST에서 k-1개의 큰 간선 제거
 *    - 각 마을의 최소 크기 제약이 있는 경우
 *    - 분할 비용에 추가 제약이 있는 경우
 * 
 * === 알고리즘 설계 ===
 * 1) 기본 접근법:
 *    - 표준 크루스칼 알고리즘으로 MST 구성
 *    - MST 구성 과정에서 선택된 간선들을 저장
 *    - MST 완성 후 가장 큰 간선을 찾아 제거
 * 
 * 2) 최적화된 접근법:
 *    - MST 구성 과정에서 동시에 최대값 추적
 *    - 별도의 최대값 탐색 과정 생략
 *    - 메모리 사용량 절약
 * 
 * 3) 구현 전략:
 *    - Union-Find 자료구조 활용
 *    - 간선 정렬 후 탐욕적 선택
 *    - 실시간 최대값 갱신
 * 
 * === 구현 세부사항 ===
 * 1) 크루스칼 알고리즘 변형:
 *    - 기본 MST 알고리즘과 동일한 구조
 *    - 선택된 간선 중 최대값을 실시간으로 추적
 *    - 최종 결과에서 최대값을 차감
 * 
 * 2) 자료구조 최적화:
 *    - Union-Find: 경로 압축 + 랭크 기반 합집합
 *    - 간선 정렬: Arrays.sort() 또는 Collections.sort()
 *    - int vs long: 최대 간선 비용 고려
 * 
 * 3) 경계 조건 처리:
 *    - N=2인 경우: MST가 간선 1개, 제거 후 비용 0
 *    - 연결되지 않은 그래프: 문제 조건상 항상 연결됨
 *    - 동일한 가중치 간선들: 어느 것을 제거해도 결과 동일
 * 
 * === 시간/공간 복잡도 ===
 * - 시간복잡도: O(E log E) - 간선 정렬이 지배적
 * - 공간복잡도: O(V + E) - Union-Find + 간선 저장
 * - 최적화된 구현: 추가 배열 없이 실시간 처리
 * 
 * === 고급 최적화 기법 ===
 * 1) 메모리 최적화:
 *    - 간선 정보를 배열로 직접 관리
 *    - 객체 생성 오버헤드 최소화
 *    - primitive 타입 사용
 * 
 * 2) 입출력 최적화:
 *    - BufferedReader + StringTokenizer
 *    - StringBuilder를 통한 출력 버퍼링
 *    - Scanner 대신 빠른 입력 방식
 * 
 * 3) 알고리즘 변형:
 *    - 프림 알고리즘으로도 해결 가능
 *    - Reverse-Delete 알고리즘 적용 가능
 * 
 * === 실전 코딩테스트 대비 포인트 ===
 * 1) 문제 인식:
 *    - "분할"이라는 키워드에서 MST 제거 아이디어 도출
 *    - 최소 비용 + 연결성 유지 = MST 활용
 * 
 * 2) 구현 주의사항:
 *    - long 타입 사용 (간선 비용 합이 클 수 있음)
 *    - N=2 특수 케이스 처리
 *    - Union-Find 구현 정확성
 * 
 * 3) 테스트 케이스:
 *    - 최소 케이스: N=2, 간선 1개
 *    - 완전 그래프: 모든 정점이 연결된 경우
 *    - 체인 그래프: 일직선으로 연결된 경우
 * 
 * === 관련 문제 유형 ===
 * 1) MST 응용:
 *    - 최소 스패닝 트리 (기본)
 *    - 네트워크 연결 (프림 알고리즘)
 *    - 최소 비용 신장 트리
 * 
 * 2) 그래프 분할:
 *    - 그래프 컷 문제
 *    - 클러스터링 문제
 *    - 네트워크 분할 최적화
 * 
 * 3) 변형 문제:
 *    - k개 그룹으로 분할
 *    - 각 그룹 크기 제약
 *    - 분할 비용 최소화
 * 
 * === 확장 응용 ===
 * 1) 실제 도시 계획:
 *    - 상수도 관망 설계
 *    - 전력 배전망 구축
 *    - 통신망 분할 운영
 * 
 * 2) 클러스터 분석:
 *    - 데이터 마이닝에서 군집화
 *    - 이미지 세그멘테이션
 *    - 소셜 네트워크 분석
 * 
 * 3) 최적화 문제:
 *    - 시설 배치 문제
 *    - 운송 네트워크 설계
 *    - 자원 배분 최적화
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
            
            if (rootX == rootY) return false;
            
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
        int N = sc.nextInt(); // 집의 개수
        int M = sc.nextInt(); // 길의 개수
        
        List<Edge> edges = new ArrayList<>();
        
        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt() - 1; // 0-based 인덱스
            int v = sc.nextInt() - 1;
            int weight = sc.nextInt();
            edges.add(new Edge(u, v, weight));
        }
        
        // 도시 분할 최소 비용 계산
        long minCost = solveCityDivision(N, edges);
        System.out.println(minCost);
    }
    
    /**
     * 도시 분할 문제를 해결
     * MST를 구성한 후 가장 큰 간선을 제거하여 두 마을로 분할
     * 
     * @param N 집의 개수
     * @param edges 길 정보
     * @return 두 마을 유지에 필요한 최소 비용
     */
    static long solveCityDivision(int N, List<Edge> edges) {
        // 1. 간선들을 가중치 기준으로 정렬
        Collections.sort(edges);
        
        // 2. Union-Find 초기화
        UnionFind uf = new UnionFind(N);
        
        long totalWeight = 0;
        int maxWeight = 0;  // MST에서 가장 큰 간선의 가중치
        int edgeCount = 0;
        
        // 3. 크루스칼 알고리즘으로 MST 구성
        for (Edge edge : edges) {
            if (uf.union(edge.u, edge.v)) {
                totalWeight += edge.weight;
                maxWeight = Math.max(maxWeight, edge.weight); // 최대값 갱신
                edgeCount++;
                
                // MST 완성 (N-1개 간선)
                if (edgeCount == N - 1) {
                    break;
                }
            }
        }
        
        // 4. MST에서 가장 큰 간선을 제거한 비용 반환
        // 두 개의 마을로 분할되므로 가장 큰 간선을 제거
        return totalWeight - maxWeight;
    }
}