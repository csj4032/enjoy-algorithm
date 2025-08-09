package p13549;

/*
 * 백준 13549번: 숨바꼭질 3
 * https://www.acmicpc.net/problem/13549
 * 
 * [문제 분류] BFS / 그래프 탐색 / 다익스트라 / 0-1 BFS
 * [난이도] Gold 5
 * 
 * [문제 요약]
 * 수빈이는 현재 점 N에 있고, 동생은 점 K에 있다.
 * - 걷기: X-1 또는 X+1로 이동 (1초 소요)
 * - 순간이동: 2*X로 이동 (0초 소요)
 * 수빈이가 동생을 찾는 가장 빠른 시간을 구하시오.
 * 
 * [제약 조건]
 * - 0 ≤ N, K ≤ 100,000
 * 
 * [알고리즘 설명 - 0-1 BFS vs 다익스트라]
 * 1. 핵심 차이점: 순간이동은 0초, 걷기는 1초
 * 2. 가중치가 0과 1로만 구성된 최단경로 문제
 * 3. 두 가지 해결 방법 가능:
 *    - 0-1 BFS (덱 사용)
 *    - 다익스트라 알고리즘 (우선순위 큐 사용)
 * 
 * [1697번과의 차이점]
 * 1697번 (숨바꼭질):
 * - 모든 이동이 1초 → 일반 BFS
 * - 처음 도달한 순간이 최단시간
 * 
 * 13549번 (숨바꼭질 3):
 * - 순간이동 0초, 걷기 1초 → 가중치 있는 그래프
 * - 0-1 BFS 또는 다익스트라 필요
 * 
 * [0-1 BFS 해법]
 * - 가중치가 0인 간선: 덱의 앞쪽에 추가 (높은 우선순위)
 * - 가중치가 1인 간선: 덱의 뒤쪽에 추가 (낮은 우선순위)
 * - 시간복잡도: O(V + E)
 * 
 * Deque<State> deque = new ArrayDeque<>();
 * 
 * while (!deque.isEmpty()) {
 *     State current = deque.pollFirst();
 *     
 *     // 순간이동 (0초) - 앞쪽에 추가
 *     if (next * 2 <= 100000 && !visited[next * 2]) {
 *         deque.addFirst(new State(next * 2, time));
 *     }
 *     
 *     // 걷기 (1초) - 뒤쪽에 추가  
 *     deque.addLast(new State(next + 1, time + 1));
 *     deque.addLast(new State(next - 1, time + 1));
 * }
 * 
 * [다익스트라 해법]
 * - 우선순위 큐 사용하여 시간이 적은 상태부터 처리
 * - 더 일반적이지만 0-1 BFS보다 느림
 * - 시간복잡도: O((V + E) log V)
 * 
 * PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
 * 
 * [구현 시 주의사항]
 * 1. 순간이동 범위 체크: 2*X ≤ 100,000
 * 2. 음수 방지: X-1 ≥ 0  
 * 3. 중복 방문 방지: 더 적은 시간으로 도달한 경우만 처리
 * 4. 조기 종료: 목표 지점 도달 시 즉시 반환
 * 
 * [최적화 전략]
 * 1. 순간이동을 우선적으로 처리 (0초이므로)
 * 2. 이미 더 적은 시간으로 방문한 위치는 스킵
 * 3. 범위를 벗어나는 위치는 탐색하지 않음
 * 
 * [경계 조건]
 * 1. N == K인 경우: 0초
 * 2. N > K인 경우: 걸어서만 이동 가능 (N-K)초
 * 3. 순간이동으로 K를 넘어선 경우: 걸어서 돌아와야 함
 * 
 * [예시 분석]
 * N=5, K=17인 경우:
 * 1. 5 → 10 (순간이동, 0초)
 * 2. 10 → 9 (걷기, 1초)  
 * 3. 9 → 18 (순간이동, 1초)
 * 4. 18 → 17 (걷기, 2초)
 * 답: 2초
 * 
 * [코딩테스트 관점]  
 * - 가중치가 있는 최단경로 문제 인식 능력
 * - 0-1 BFS 패턴 이해
 * - 다익스트라와 BFS의 차이점 이해
 * - 상황에 맞는 알고리즘 선택 능력
 * 
 * [관련 문제들]
 * - 숨바꼭질 (1697번) - 기본 BFS
 * - 숨바꼭질 2 (12851번) - 최단시간과 경우의 수
 * - 숨바꼭질 4 (13913번) - 경로 복원
 * - 최단경로 (1753번) - 다익스트라 기본
 * 
 * [실제 응용]
 * - 게임에서 스킬 쿨타임을 고려한 최적 이동
 * - 교통비와 시간을 고려한 경로 탐색
 * - 네트워크에서 지연시간 최소화
 * 
 * [시간복잡도] O(N) - 0-1 BFS 사용 시
 * [공간복잡도] O(N) - 방문 배열과 덱 공간
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    
    static final int MAX_RANGE = 100000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치
        
        // 0-1 BFS로 최단시간 탐색
        System.out.println(bfs01(N, K));
    }
    
    /**
     * 0-1 BFS를 이용한 최단시간 탐색
     * @param start 시작 위치
     * @param target 목표 위치
     * @return 최단 시간
     */
    private static int bfs01(int start, int target) {
        if (start == target) return 0;
        
        int[] dist = new int[MAX_RANGE + 1]; // 각 위치까지의 최단시간
        boolean[] visited = new boolean[MAX_RANGE + 1]; // 방문 체크
        
        // 거리 배열 초기화 (무한대로 설정)
        for (int i = 0; i <= MAX_RANGE; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        Deque<Integer> deque = new ArrayDeque<>(); // 0-1 BFS를 위한 덱
        
        deque.addFirst(start);
        dist[start] = 0;
        
        while (!deque.isEmpty()) {
            int current = deque.pollFirst();
            
            // 이미 더 좋은 경로로 방문된 경우 스킵
            if (visited[current]) continue;
            visited[current] = true;
            
            // 목표 위치에 도달한 경우
            if (current == target) {
                return dist[current];
            }
            
            // 1. 순간이동 (0초) - 덱의 앞쪽에 추가
            int teleport = current * 2;
            if (teleport <= MAX_RANGE && dist[teleport] > dist[current]) {
                dist[teleport] = dist[current];
                deque.addFirst(teleport);
            }
            
            // 2. 앞으로 걷기 (1초) - 덱의 뒤쪽에 추가
            int forward = current + 1;
            if (forward <= MAX_RANGE && dist[forward] > dist[current] + 1) {
                dist[forward] = dist[current] + 1;
                deque.addLast(forward);
            }
            
            // 3. 뒤로 걷기 (1초) - 덱의 뒤쪽에 추가
            int backward = current - 1;
            if (backward >= 0 && dist[backward] > dist[current] + 1) {
                dist[backward] = dist[current] + 1;
                deque.addLast(backward);
            }
        }
        
        return dist[target];
    }
}