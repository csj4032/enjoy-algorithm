package p4963;

import java.util.Scanner;

/**
 * 백준 4963번: 섬의 개수 (Silver 2)
 * https://www.acmicpc.net/problem/4963
 * 
 * 문제 분류: 그래프 탐색, DFS, BFS, 연결 컴포넌트
 * 핵심 알고리즘: DFS를 이용한 8방향 연결 컴포넌트 찾기
 * 
 * 해결 접근 방법:
 * 1. 지도를 2차원 배열로 입력받아 저장 (1: 땅, 0: 바다)
 * 2. 모든 위치를 순회하면서 땅(1)이면서 방문하지 않은 곳에서 DFS 시작
 * 3. DFS로 8방향(상하좌우 + 대각선)으로 연결된 모든 땅을 방문
 * 4. 각 DFS 호출이 하나의 섬을 의미하므로 섬의 개수를 센다
 * 
 * 시간복잡도: O(W × H) - 모든 칸을 최대 한 번씩 방문
 * 공간복잡도: O(W × H) - 지도와 방문 배열
 * 
 * 특징:
 * - 일반적인 4방향과 달리 8방향(대각선 포함) 탐색
 * - 대각선으로 연결된 땅도 같은 섬으로 인정
 * - 여러 테스트 케이스를 처리 (0 0 입력시 종료)
 */
public class Main {

	// 8방향 이동 (상하좌우 + 대각선 4방향)
	private static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int w = sc.nextInt(); // 지도 가로 크기
			int h = sc.nextInt(); // 지도 세로 크기
			
			// 종료 조건
			if (w == 0 && h == 0) break;

			int islandCount = 0; // 섬의 개수
			int[][] map = new int[h][w]; // 지도 (1: 땅, 0: 바다)
			boolean[][] visited = new boolean[h][w]; // 방문 체크
			
			// 지도 입력
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 모든 위치에서 DFS 시도
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					// 땅이고 아직 방문하지 않은 위치라면
					if (map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j, h, w, map, visited); // 연결된 모든 땅 방문
						islandCount++; // 새로운 섬 발견
					}
				}
			}
			
			System.out.println(islandCount);
		}
	}

	/**
	 * 깊이 우선 탐색으로 8방향 연결된 땅들을 모두 방문
	 * 
	 * @param y 현재 행 위치
	 * @param x 현재 열 위치
	 * @param h 지도 세로 크기
	 * @param w 지도 가로 크기
	 * @param map 지도 정보
	 * @param visited 방문 체크 배열
	 */
	private static void dfs(int y, int x, int h, int w, int[][] map, boolean[][] visited) {
		// 현재 위치 방문 처리
		visited[y][x] = true;
		
		// 8방향으로 탐색 (상하좌우 + 대각선)
		for (int dir = 0; dir < 8; dir++) {
			int ny = y + dy[dir]; // 새로운 행 위치
			int nx = x + dx[dir]; // 새로운 열 위치
			
			// 범위를 벗어나지 않고, 땅이며, 아직 방문하지 않았다면
			if (isValid(ny, nx, h, w) && map[ny][nx] == 1 && !visited[ny][nx]) {
				dfs(ny, nx, h, w, map, visited); // 재귀적으로 탐색 계속
			}
		}
	}
	
	/**
	 * 좌표가 유효한 범위 내에 있는지 확인
	 */
	private static boolean isValid(int y, int x, int h, int w) {
		return y >= 0 && y < h && x >= 0 && x < w;
	}
}