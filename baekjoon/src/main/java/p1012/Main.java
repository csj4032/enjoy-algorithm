package p1012;

import java.util.Scanner;

/**
 * 백준 1012번: 유기농 배추 (Silver 2)
 * https://www.acmicpc.net/problem/1012
 * 
 * 문제 분류: 그래프 탐색, DFS, BFS, 연결 컴포넌트
 * 핵심 알고리즘: DFS를 이용한 연결 컴포넌트 개수 찾기
 * 
 * 해결 접근 방법:
 * 1. 배추밭을 2차원 격자로 모델링
 * 2. 배추가 심어진 위치에서 시작해서 인접한 배추들을 DFS로 탐색
 * 3. 한 번의 DFS로 연결된 모든 배추를 방문 (하나의 연결 컴포넌트)
 * 4. 각 연결 컴포넌트마다 배추흰지렁이 1마리 필요
 * 
 * 시간복잡도: O(M × N) - 모든 칸을 최대 한 번씩 방문
 * 공간복잡도: O(M × N) - 배추밭과 방문 배열
 * 
 * 그래프 이론 개념:
 * - 연결 컴포넌트 (Connected Component)
 * - 깊이 우선 탐색 (DFS)
 * - 인접한 칸: 상하좌우 4방향
 */
public class Main {

    private static int M, N; // 가로, 세로 크기
    private static int[][] field; // 배추밭 (1: 배추 있음, 0: 없음)
    private static boolean[][] visited; // 방문 체크
    
    // 상하좌우 4방향 이동을 위한 배열
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int tc = 0; tc < T; tc++) {
            M = sc.nextInt(); // 배추밭 가로 길이
            N = sc.nextInt(); // 배추밭 세로 길이
            int K = sc.nextInt(); // 배추가 심어진 위치의 개수
            
            // 배추밭 초기화
            field = new int[N][M];
            visited = new boolean[N][M];
            
            // 배추 위치 입력
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt(); // 가로 좌표
                int y = sc.nextInt(); // 세로 좌표
                field[y][x] = 1; // 배추 표시
            }
            
            int wormCount = 0; // 필요한 배추흰지렁이 수
            
            // 모든 위치에서 DFS 시도
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 배추가 있고 아직 방문하지 않은 위치라면
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j); // 연결된 모든 배추 방문
                        wormCount++; // 하나의 연결 컴포넌트 완료
                    }
                }
            }
            
            System.out.println(wormCount);
        }
    }

    /**
     * 깊이 우선 탐색으로 연결된 배추들을 모두 방문
     * 
     * @param y 현재 세로 위치
     * @param x 현재 가로 위치
     */
    private static void dfs(int y, int x) {
        // 현재 위치 방문 처리
        visited[y][x] = true;
        
        // 4방향으로 탐색
        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir]; // 새로운 세로 위치
            int nx = x + dx[dir]; // 새로운 가로 위치
            
            // 범위를 벗어나지 않고, 배추가 있으며, 아직 방문하지 않았다면
            if (isValid(ny, nx) && field[ny][nx] == 1 && !visited[ny][nx]) {
                dfs(ny, nx); // 재귀적으로 탐색 계속
            }
        }
    }
    
    /**
     * 좌표가 유효한 범위 내에 있는지 확인
     */
    private static boolean isValid(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}