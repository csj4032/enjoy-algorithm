package p2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 2252번: 줄 세우기 (Gold 3)
 * https://www.acmicpc.net/problem/2252
 * 
 * == 문제 분류 ==
 * 위상 정렬, 그래프 이론
 * 
 * == 알고리즘 이론 ==
 * 1. 위상 정렬 (Topological Sort)
 *    - DAG(Directed Acyclic Graph)에서 정점들의 선형 순서
 *    - 모든 방향 간선 (u,v)에 대해 u가 v보다 앞에 위치
 *    - 사이클이 없는 방향 그래프에서만 가능
 * 
 * 2. 칸의 알고리즘 (Kahn's Algorithm)
 *    - 진입 차수(In-degree) 기반 BFS 방식
 *    - 진입 차수가 0인 정점부터 순차적으로 제거
 *    - 큐를 이용한 반복적 구현
 * 
 * 3. 대안: DFS 기반 위상 정렬
 *    - 후위 순회(Post-order) 역순으로 정렬
 *    - 재귀적 구현 가능
 * 
 * == 핵심 아이디어 ==
 * 1. 각 정점의 진입 차수 계산
 * 2. 진입 차수가 0인 정점들을 큐에 추가
 * 3. 큐에서 정점을 제거하며 연결된 정점들의 진입 차수 감소
 * 4. 새로 진입 차수가 0이 된 정점들을 큐에 추가
 * 5. 큐가 빌 때까지 반복
 * 
 * == 시간복잡도 ==
 * O(V + E) - V: 정점 수, E: 간선 수
 * 
 * == 공간복잡도 ==
 * O(V + E) - 인접 리스트 + 진입 차수 배열
 * 
 * == 구현 최적화 기법 ==
 * 1. 인접 리스트로 그래프 표현
 * 2. 큐를 이용한 BFS 기반 구현
 * 3. 진입 차수 배열로 효율적 관리
 * 
 * == 사이클 검출 ==
 * - 위상 정렬 결과의 정점 수 < 전체 정점 수이면 사이클 존재
 * - DAG 검증에 활용 가능
 * 
 * == 실무 응용 ==
 * - 작업 스케줄링 (Prerequisites)
 * - 패키지 의존성 관리
 * - 컴파일 순서 결정
 * - 프로젝트 계획 수립
 * 
 * == 관련 심화 문제 ==
 * - 백준 2623: 음악프로그램 (위상 정렬 + 사이클 검출)
 * - 백준 1766: 문제집 (위상 정렬 + 우선순위 큐)
 * - 백준 14567: 선수과목 (위상 정렬 응용)
 */
public class Main {

    static List<List<Integer>> graph;
    static List<Integer> order;
    static LinkedList<Integer> queue;
    static LinkedList<Integer> result;
    static int[] count;
    private static Integer n;
    private static Integer m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        order = new ArrayList<>();
        graph = new ArrayList<>();
        result = new LinkedList<>();
        queue = new LinkedList<>();
        count = new int[n + 1];

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            order.add(a);
            count[b]++;
        }
        topologicalSort();
        while (!result.isEmpty()) System.out.print(result.poll() + " ");
    }

    private static void topologicalSort() {
        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int h = queue.poll();
            result.offer(h);
            for (int v : graph.get(h)) {
                count[v]--;
                if (count[v] == 0) queue.offer(v);
            }
        }
    }
}