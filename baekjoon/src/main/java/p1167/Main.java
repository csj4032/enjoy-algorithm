package p1167;

import java.util.*;

/**
 * 제목 : 트리의 지름
 * 링크 : https://www.acmicpc.net/problem/1167
 * 분류 : 트리, DFS, BFS, 트리의 지름
 * 
 * === 문제 해설 ===
 * 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 구하는 문제입니다.
 * 트리의 지름(diameter)을 구하는 대표적인 문제입니다.
 * 
 * === 수학적/이론적 배경 ===
 * 1) 트리의 지름 정의:
 *    - 트리에서 가장 멀리 떨어진 두 정점 사이의 거리
 *    - 트리의 가장 긴 경로의 길이
 *    - 모든 정점 쌍 (u,v)에 대한 거리의 최댓값
 * 
 * 2) 트리의 지름 성질:
 *    - 트리의 지름을 이루는 경로는 유일하지 않을 수 있음
 *    - 지름의 양 끝점은 항상 리프 노드 (차수가 1인 노드)
 *    - 트리에서 임의의 점에서 가장 먼 점은 지름의 한쪽 끝점
 * 
 * 3) 2-DFS/BFS 알고리즘의 정당성:
 *    - 1단계: 임의의 정점에서 가장 먼 정점 u를 찾음
 *    - 2단계: u에서 가장 먼 정점 v를 찾음
 *    - u와 v 사이의 거리가 트리의 지름
 *    - 증명: 트리의 구조적 특성과 최적 부분구조 성질 이용
 * 
 * === 알고리즘 설계 ===
 * 1) 2-DFS 알고리즘:
 *    - 첫 번째 DFS: 임의의 정점(보통 1번)에서 시작하여 가장 먼 정점 찾기
 *    - 두 번째 DFS: 첫 번째에서 찾은 정점에서 시작하여 가장 먼 정점과 거리 찾기
 *    - 시간복잡도: O(V) - 각 DFS가 모든 정점을 한 번씩 방문
 * 
 * 2) 대안 알고리즘:
 *    - 모든 정점 쌍 거리 계산: O(V²) - 비효율적
 *    - 트리 DP: O(V) - 복잡한 구현
 *    - 2-BFS: DFS와 동일한 원리
 * 
 * 3) 구현 전략:
 *    - 인접 리스트로 가중치 있는 트리 표현
 *    - DFS 재귀 또는 스택을 이용한 구현
 *    - 거리 배열을 통한 최대 거리 추적
 * 
 * === 구현 세부사항 ===
 * 1) 그래프 표현:
 *    - List<Node>[] 인접 리스트
 *    - Node 클래스: 정점 번호와 가중치 저장
 *    - 무향 트리이므로 양방향 간선 추가
 * 
 * 2) DFS 구현:
 *    - 재귀 함수로 구현
 *    - visited 배열로 방문 체크
 *    - 현재까지의 거리 누적 계산
 *    - 최대 거리와 해당 정점 갱신
 * 
 * 3) 입력 처리:
 *    - 특수한 입력 형식: 각 줄이 -1로 끝남
 *    - 정점 번호, 가중치가 번갈아 등장
 *    - StringTokenizer 또는 Scanner로 파싱
 * 
 * === 시간/공간 복잡도 ===
 * - 시간복잡도: O(V) - 두 번의 DFS, 각각 O(V)
 * - 공간복잡도: O(V) - 인접 리스트 + DFS 스택 공간
 * - 트리의 간선 수: V-1개이므로 O(V) = O(E+V)
 * 
 * === 고급 최적화 기법 ===
 * 1) 메모리 최적화:
 *    - primitive 배열 사용
 *    - Node 클래스 대신 두 개의 배열 사용
 *    - visited 배열 재사용
 * 
 * 2) 시간 최적화:
 *    - BFS 사용시 큐 재사용
 *    - 조기 종료 조건 추가
 *    - 캐시 지역성 고려한 데이터 구조
 * 
 * 3) 트리 DP 접근법:
 *    - 각 정점에서의 최대 깊이 계산
 *    - 부모-자식 관계에서 최적 부분구조 활용
 *    - 리턴 값을 통한 상향식 계산
 * 
 * === 실전 코딩테스트 대비 포인트 ===
 * 1) 입력 형식 주의:
 *    - 각 줄이 -1로 끝나는 특수 형식
 *    - 정점 번호와 가중치가 교대로 등장
 *    - EOF까지 읽어야 하는 경우도 있음
 * 
 * 2) 구현 주의사항:
 *    - 무향 그래프이므로 양방향 간선 추가
 *    - 첫 번째 DFS 결과를 두 번째 DFS의 시작점으로 사용
 *    - long 타입 사용 (거리 합이 클 수 있음)
 * 
 * 3) 디버깅 포인트:
 *    - 첫 번째 DFS에서 올바른 끝점을 찾았는지 확인
 *    - 가중치 누적 계산이 정확한지 검증
 *    - visited 배열 초기화 누락 확인
 * 
 * === 관련 알고리즘 패러다임 ===
 * 1) 그래프 탐색:
 *    - DFS/BFS의 응용
 *    - 트리 순회 알고리즘
 *    - 최단경로 문제의 특수 케이스
 * 
 * 2) 동적 계획법:
 *    - 트리 DP의 대표 문제
 *    - 최적 부분구조 활용
 *    - 상향식/하향식 접근법
 * 
 * 3) 분할 정복:
 *    - 트리의 재귀적 구조 활용
 *    - 서브트리 단위 문제 분할
 *    - 결과 합성을 통한 전체 최적해 도출
 * 
 * === 실제 응용 사례 ===
 * 1) 네트워크 분석:
 *    - 통신망에서 최대 지연시간 계산
 *    - 네트워크 취약점 분석
 *    - 라우팅 최적화
 * 
 * 2) 생물정보학:
 *    - 계통수(phylogenetic tree) 분석
 *    - 진화 거리 계산
 *    - 분자 구조 분석
 * 
 * 3) 소프트웨어 공학:
 *    - 의존성 그래프 분석
 *    - 모듈 간 결합도 측정
 *    - 코드 복잡도 분석
 * 
 * === 확장 문제들 ===
 * 1) 가중치 없는 트리의 지름
 * 2) 트리에서 k개 정점까지의 최대 거리 합
 * 3) 트리의 중심(center) 찾기
 * 4) 트리의 반지름(radius) 계산
 * 5) 동적 트리에서의 지름 유지
 */
public class Main {
    
    static class Node {
        int vertex, weight;
        
        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    
    static List<Node>[] graph;
    static boolean[] visited;
    static long maxDistance;
    static int farthestNode;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // 그래프 초기화
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 트리 간선 정보 입력
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v, w;
            
            // 각 줄이 -1로 끝날 때까지 간선 정보 읽기
            while ((v = sc.nextInt()) != -1) {
                w = sc.nextInt();
                graph[u].add(new Node(v, w));
                graph[v].add(new Node(u, w)); // 무향 그래프
            }
        }
        
        // 트리의 지름 계산
        long diameter = findTreeDiameter(n);
        System.out.println(diameter);
    }
    
    /**
     * 2-DFS 알고리즘으로 트리의 지름을 구함
     * 
     * @param n 정점의 개수
     * @return 트리의 지름
     */
    static long findTreeDiameter(int n) {
        // 1단계: 임의의 정점(1번)에서 가장 먼 정점 찾기
        visited = new boolean[n + 1];
        maxDistance = 0;
        farthestNode = 1;
        
        dfs(1, 0);
        
        // 2단계: 1단계에서 찾은 정점에서 가장 먼 정점까지의 거리 구하기
        Arrays.fill(visited, false);
        maxDistance = 0;
        
        dfs(farthestNode, 0);
        
        return maxDistance;
    }
    
    /**
     * DFS를 이용하여 현재 정점에서 가장 먼 정점과 거리를 찾음
     * 
     * @param node 현재 정점
     * @param distance 현재까지의 누적 거리
     */
    static void dfs(int node, long distance) {
        visited[node] = true;
        
        // 현재 거리가 최대 거리보다 크면 갱신
        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }
        
        // 인접한 모든 정점에 대해 DFS 수행
        for (Node neighbor : graph[node]) {
            if (!visited[neighbor.vertex]) {
                dfs(neighbor.vertex, distance + neighbor.weight);
            }
        }
    }
}