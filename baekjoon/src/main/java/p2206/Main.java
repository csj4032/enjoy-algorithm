package p2206;

/*
 * 백준 2206번: 벽 부수고 이동하기
 * https://www.acmicpc.net/problem/2206
 * 
 * [문제 분류] BFS / 그래프 탐색 / 3차원 상태 공간
 * [난이도] Gold 3
 * 
 * [문제 요약]
 * N×M 지도에서 (1,1)에서 (N,M)으로 이동하는 최단 경로를 구하는 문제.
 * 단, 이동하는 중에 벽을 1개까지 부술 수 있다.
 * - 0: 이동할 수 있는 곳, 1: 벽
 * - 시작점과 도착점도 칸 수에 포함
 * 
 * [제약 조건]
 * - 1 ≤ N, M ≤ 1,000
 * - 지도는 0과 1로만 구성
 * 
 * [알고리즘 설명 - 3차원 BFS]
 * 1. 핵심 아이디어: 벽을 부순 상태와 부수지 않은 상태를 별개의 상태로 관리
 * 2. 3차원 상태 공간: (행, 열, 벽을 부순 횟수)
 * 3. 벽을 부순 횟수는 0 또는 1 (최대 1개까지만 부술 수 있음)
 * 4. BFS로 최단 경로 탐색
 * 
 * [상태 정의]
 * - (r, c, broken): 위치 (r, c)에서 벽을 broken개 부순 상태
 * - broken = 0: 아직 벽을 부수지 않은 상태
 * - broken = 1: 벽을 1개 부순 상태
 * 
 * [전이 규칙]
 * 현재 상태 (r, c, broken)에서:
 * 1. 다음 칸이 빈 공간(0)인 경우:
 *    → (nr, nc, broken)로 이동 (벽을 부순 횟수 유지)
 * 
 * 2. 다음 칸이 벽(1)이고 아직 벽을 부수지 않은 경우(broken = 0):
 *    → (nr, nc, 1)로 이동 (벽을 부수고 이동)
 * 
 * 3. 다음 칸이 벽(1)이지만 이미 벽을 부순 경우(broken = 1):
 *    → 이동 불가
 * 
 * [3차원 방문 배열]
 * - visited[r][c][broken]: (r, c) 위치에 벽을 broken개 부수고 도달했는지 여부
 * - 같은 위치라도 벽을 부순 상태에 따라 다른 상태로 취급
 * 
 * [구현 세부사항]
 * 1. Queue에 (행, 열, 벽 부순 횟수, 이동 거리) 저장
 * 2. 3차원 방문 배열 사용: boolean[N][M][2]
 * 3. 목표 지점 도달 시 즉시 결과 반환
 * 4. 큐가 비워질 때까지 답을 찾지 못하면 -1 반환
 * 
 * [일반적인 BFS와의 차이점]
 * 일반 BFS:
 * - 2차원 상태 공간 (행, 열)
 * - 한 번 방문한 위치는 다시 방문하지 않음
 * 
 * 벽 부수기 BFS:
 * - 3차원 상태 공간 (행, 열, 벽 부순 횟수)
 * - 같은 위치라도 벽을 부순 상태에 따라 다르게 취급
 * - 더 적은 벽을 부수고 도달한 경우가 더 유리할 수 있음
 * 
 * [최적화 고려사항]
 * 1. 목표 지점 도달 시 즉시 종료 (조기 종료)
 * 2. 범위 체크를 큐에 넣기 전에 수행
 * 3. BufferedReader로 빠른 입력 처리
 * 
 * [경계 조건 처리]
 * 1. 시작점과 목표점이 같은 경우: 1 반환
 * 2. 시작점이나 목표점이 벽인 경우: 특별 처리 필요
 * 3. 경로가 존재하지 않는 경우: -1 반환
 * 
 * [코딩테스트 관점]
 * - 상태 공간 확장 능력
 * - 3차원 BFS 구현 능력
 * - 복잡한 조건 처리 능력
 * - 메모리 관리 (3차원 배열)
 * 
 * [관련 문제들]
 * - 미로 탐색 (2178번) - 기본 BFS
 * - 벽 부수고 이동하기 2 (14442번) - K개까지 부술 수 있는 확장
 * - 벽 부수고 이동하기 3 (16933번) - 낮/밤 개념 추가
 * - 벽 부수고 이동하기 4 (16946번) - 각 벽을 부쉈을 때의 최대 이동 가능 칸 수
 * 
 * [실제 응용]
 * - 게임에서 특수 능력(벽 통과) 사용 시 최적 경로
 * - 로봇 네비게이션에서 장애물 제거 비용 고려
 * - 네트워크에서 일부 연결 끊기를 허용한 최단 경로
 * 
 * [시간복잡도] O(N × M) - 각 칸을 최대 2번(벽 부순 상태별로) 방문
 * [공간복잡도] O(N × M) - 3차원 방문 배열과 큐 공간
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    // 4방향 이동 벡터 (상, 하, 좌, 우)
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static int N, M; // 지도 크기
    static int[][] map; // 지도 (0: 빈 공간, 1: 벽)
    static boolean[][][] visited; // 3차원 방문 배열 [행][열][벽 부순 횟수]
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 세로 크기
        M = Integer.parseInt(st.nextToken()); // 가로 크기
        
        map = new int[N][M];
        visited = new boolean[N][M][2]; // [행][열][벽을 부순 횟수 0 or 1]
        
        // 지도 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        // BFS 실행 후 결과 출력
        System.out.println(bfs());
    }
    
    /**
     * 3차원 BFS를 이용한 벽 부수고 이동하기
     * @return 최단 경로의 칸 수 (불가능하면 -1)
     */
    private static int bfs() {
        Queue<State> queue = new LinkedList<>();
        
        // 시작점에서 BFS 시작 (0,0)에서 벽을 0개 부수고 거리 1로 시작
        queue.offer(new State(0, 0, 0, 1));
        visited[0][0][0] = true;
        
        while (!queue.isEmpty()) {
            State current = queue.poll();
            int r = current.r;
            int c = current.c;
            int broken = current.broken;
            int dist = current.dist;
            
            // 목표 지점에 도달했으면 거리 반환
            if (r == N - 1 && c == M - 1) {
                return dist;
            }
            
            // 4방향으로 이동 시도
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i]; // 새로운 행
                int nc = c + dc[i]; // 새로운 열
                
                // 범위 체크
                if (!isValid(nr, nc)) continue;
                
                // 다음 칸이 빈 공간인 경우
                if (map[nr][nc] == 0) {
                    // 같은 벽 부순 상태로 이동
                    if (!visited[nr][nc][broken]) {
                        visited[nr][nc][broken] = true;
                        queue.offer(new State(nr, nc, broken, dist + 1));
                    }
                }
                // 다음 칸이 벽이고 아직 벽을 부수지 않은 경우
                else if (map[nr][nc] == 1 && broken == 0) {
                    // 벽을 부수고 이동
                    if (!visited[nr][nc][1]) {
                        visited[nr][nc][1] = true;
                        queue.offer(new State(nr, nc, 1, dist + 1));
                    }
                }
                // 다음 칸이 벽이지만 이미 벽을 부순 경우는 이동 불가
            }
        }
        
        return -1; // 목표 지점에 도달할 수 없음
    }
    
    /**
     * 좌표가 유효한 범위 내에 있는지 확인
     */
    private static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
    
    /**
     * 상태 정보를 저장하는 클래스
     */
    static class State {
        int r, c;    // 현재 위치 (행, 열)
        int broken;  // 벽을 부순 횟수 (0 또는 1)
        int dist;    // 현재까지의 이동 거리
        
        State(int r, int c, int broken, int dist) {
            this.r = r;
            this.c = c;
            this.broken = broken;
            this.dist = dist;
        }
    }
}