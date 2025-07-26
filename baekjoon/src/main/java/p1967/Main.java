package p1967;

import java.util.*;

/**
 * 제목 : 트리의 지름
 * 링크 : https://www.acmicpc.net/problem/1967
 * 분류 : 트리, DFS, BFS, 트리의 지름
 * 
 * === 문제 해설 ===
 * 루트가 있는 트리에서 임의의 두 노드 사이의 거리 중 가장 긴 것을 구하는 문제입니다.
 * p1167과 동일한 트리의 지름 문제이지만 입력 형식이 다릅니다.
 * 
 * === 핵심 차이점 ===
 * 1) 입력 형식:
 *    - p1167: 각 줄이 -1로 끝나는 형식
 *    - p1967: 부모-자식 관계로 주어지는 형식
 *    - 더 직관적인 트리 구조 표현
 * 
 * 2) 트리 구조:
 *    - 명시적인 루트 노드 (1번)
 *    - 부모에서 자식으로의 방향성 있는 입력
 *    - 하지만 알고리즘에서는 무향 그래프로 처리
 * 
 * 3) 정점 번호:
 *    - 1번부터 N번까지의 연속된 번호
 *    - 0번 정점은 존재하지 않음
 * 
 * === 수학적/이론적 배경 ===
 * 1) 루트 트리 vs 일반 트리:
 *    - 루트 트리: 계층 구조가 명확한 트리
 *    - 일반 트리: 방향성이 없는 연결된 비순환 그래프
 *    - 지름 계산에서는 방향성 무시하고 처리
 * 
 * 2) 트리의 지름 불변성:
 *    - 루트의 위치와 무관하게 지름은 동일
 *    - 트리의 구조적 특성은 변하지 않음
 *    - 같은 2-DFS 알고리즘 적용 가능
 * 
 * 3) 부모-자식 관계의 활용:
 *    - 트리 DP에서 부모-자식 관계 명확
 *    - 상향식/하향식 접근법 모두 가능
 *    - 재귀 호출의 기저 사례 명확
 * 
 * === 알고리즘 설계 ===
 * 1) 2-DFS 알고리즘 (동일):
 *    - 첫 번째 DFS: 임의 정점에서 가장 먼 정점 찾기
 *    - 두 번째 DFS: 찾은 정점에서 최종 지름 계산
 *    - 시간복잡도: O(N)
 * 
 * 2) 트리 DP 접근법:
 *    - 각 노드에서 자식 방향으로의 최대 거리 계산
 *    - 부모로 향하는 경로와 자식으로 향하는 경로 비교
 *    - 더 복잡하지만 한 번의 순회로 해결 가능
 * 
 * 3) 구현 선택:
 *    - 2-DFS: 구현이 간단하고 직관적
 *    - 트리 DP: 약간 더 효율적이지만 복잡
 *    - 문제 크기에 따라 선택
 * 
 * === 구현 세부사항 ===
 * 1) 입력 처리:
 *    - N-1개의 간선 정보
 *    - (부모, 자식, 가중치) 형태
 *    - 양방향 그래프로 저장
 * 
 * 2) 자료구조:
 *    - List<Node>[] 인접 리스트
 *    - Node: vertex, weight 저장
 *    - visited 배열로 중복 방문 방지
 * 
 * 3) DFS 구현:
 *    - 재귀 함수 사용
 *    - 거리 누적 계산
 *    - 최대 거리 갱신
 * 
 * === 시간/공간 복잡도 ===
 * - 시간복잡도: O(N) - 2번의 DFS
 * - 공간복잡도: O(N) - 인접 리스트 + 재귀 스택
 * - 트리이므로 간선 수 = N-1 = O(N)
 * 
 * === 최적화 기법 ===
 * 1) 한 번의 DFS로 해결 (트리 DP):
 *    ```java
 *    // 각 노드에서 최대 2개의 자식 방향 경로 선택
 *    // 지름 = max(첫 번째 경로 + 두 번째 경로)
 *    ```
 * 
 * 2) 메모리 최적화:
 *    - 객체 생성 최소화
 *    - primitive 배열 활용
 *    - 인접 리스트 대신 인접 행렬 (조밀한 그래프)
 * 
 * 3) 입출력 최적화:
 *    - BufferedReader 사용
 *    - StringBuilder로 출력 버퍼링
 * 
 * === 실전 코딩테스트 대비 포인트 ===
 * 1) 입력 형식 구별:
 *    - p1167 vs p1967 입력 형식 차이 인지
 *    - 각 문제에 맞는 파싱 로직 구현
 *    - 간선 개수 확인 (N-1개)
 * 
 * 2) 알고리즘 선택:
 *    - 2-DFS: 구현 간단, 직관적
 *    - 트리 DP: 효율적이지만 복잡
 *    - 문제 조건에 따른 적절한 선택
 * 
 * 3) 경계 조건:
 *    - N=1: 지름 = 0
 *    - N=2: 지름 = 간선 가중치
 *    - 모든 가중치가 0인 경우
 * 
 * === 트리 DP 해법 ===
 * ```java
 * // 각 노드에서의 최대 깊이 2개를 유지
 * // dfs(node) 반환값: 해당 노드를 루트로 하는 서브트리에서의 최대 깊이
 * int dfs(int node, int parent) {
 *     int max1 = 0, max2 = 0;
 *     for (child : children of node) {
 *         if (child != parent) {
 *             int depth = dfs(child, node) + weight(node, child);
 *             if (depth > max1) {
 *                 max2 = max1;
 *                 max1 = depth;
 *             } else if (depth > max2) {
 *                 max2 = depth;
 *             }
 *         }
 *     }
 *     answer = max(answer, max1 + max2); // 지름 후보 갱신
 *     return max1;
 * }
 * ```
 * 
 * === 관련 문제 유형 ===
 * 1) 트리의 지름 기본:
 *    - p1167: 일반적인 입력 형식
 *    - p1967: 부모-자식 입력 형식
 *    - 가중치 없는 트리의 지름
 * 
 * 2) 트리 DP 응용:
 *    - 트리의 중심 찾기
 *    - 각 노드까지의 최대 거리 합
 *    - 트리에서의 최적 경로 문제
 * 
 * 3) 확장 문제:
 *    - 동적으로 변하는 트리의 지름
 *    - k개 정점을 지나는 최장 경로
 *    - 제약 조건이 있는 트리 경로
 * 
 * === 실제 응용 영역 ===
 * 1) 조직 구조 분석:
 *    - 회사 계층에서 최대 전달 시간
 *    - 의사결정 경로 최적화
 *    - 권한 위임 구조 설계
 * 
 * 2) 컴퓨터 네트워크:
 *    - 트리 토폴로지에서 최대 지연
 *    - 라우팅 테이블 최적화
 *    - 네트워크 분할 지점 결정
 * 
 * 3) 게임 이론:
 *    - 게임 트리에서 최장 경로
 *    - 의사결정 트리 분석
 *    - 전략 깊이 계산
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
        
        // n=1인 경우, 지름은 0
        if (n == 1) {
            System.out.println(0);
            return;
        }
        
        // 그래프 초기화
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 간선 정보 입력 (n-1개의 간선)
        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            int weight = sc.nextInt();
            
            // 무향 그래프로 저장
            graph[parent].add(new Node(child, weight));
            graph[child].add(new Node(parent, weight));
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