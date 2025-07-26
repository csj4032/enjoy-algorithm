package p2178;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 백준 2178번: 미로 탐색 (Silver 1)
 * https://www.acmicpc.net/problem/2178
 * 
 * 문제 분류: 그래프 탐색, BFS, 최단경로
 * 핵심 알고리즘: BFS를 이용한 최단경로 찾기
 * 
 * 해결 접근 방법:
 * 1. 미로를 2차원 배열로 입력받아 저장 (1: 이동 가능, 0: 벽)
 * 2. 시작점 (1,1)에서 BFS를 시작하여 목표점 (N,M)까지 탐색
 * 3. BFS의 특성상 처음 도달한 경로가 최단경로가 됨
 * 4. 각 칸까지의 최단거리를 기록하면서 탐색 진행
 * 
 * 시간복잡도: O(N × M) - 모든 칸을 최대 한 번씩 방문
 * 공간복잡도: O(N × M) - 미로와 거리 배열, 큐 공간
 * 
 * BFS vs DFS:
 * - BFS: 최단경로 보장, 레벨별 탐색
 * - DFS: 모든 경로 탐색, 깊이 우선
 * - 이 문제는 최단경로를 구해야 하므로 BFS가 적합
 */
public class Main {

	private static int N, M; // 미로의 크기
	private static int[][] maze; // 미로 (1: 이동가능, 0: 벽)
	private static int[][] distance; // 각 칸까지의 최단거리
	private static boolean[][] visited; // 방문 체크
	
	// 상하좌우 4방향 이동을 위한 배열
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 미로 세로 크기
		M = sc.nextInt(); // 미로 가로 크기
		
		maze = new int[N][M];
		distance = new int[N][M];
		visited = new boolean[N][M];

		// 미로 입력 (한 줄씩 문자열로 읽어서 각 자리수를 분리)
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}

		// BFS로 최단경로 탐색
		bfs(0, 0); // (1,1)에서 시작 -> 배열 인덱스로는 (0,0)

		// (N,M) 위치까지의 최단거리 출력 -> 배열 인덱스로는 (N-1, M-1)
		System.out.println(distance[N-1][M-1]);
	}

	/**
	 * 너비 우선 탐색으로 최단경로 찾기
	 * 
	 * @param startY 시작점 행 위치
	 * @param startX 시작점 열 위치
	 */
	private static void bfs(int startY, int startX) {
		Queue<Position> queue = new LinkedList<>();
		
		// 시작점 초기화
		queue.offer(new Position(startY, startX));
		visited[startY][startX] = true;
		distance[startY][startX] = 1; // 시작점도 칸 수에 포함
		
		while (!queue.isEmpty()) {
			Position current = queue.poll();
			int y = current.y;
			int x = current.x;
			
			// 4방향으로 탐색
			for (int dir = 0; dir < 4; dir++) {
				int ny = y + dy[dir]; // 새로운 행 위치
				int nx = x + dx[dir]; // 새로운 열 위치
				
				// 범위를 벗어나지 않고, 이동 가능하며, 아직 방문하지 않았다면
				if (isValid(ny, nx) && maze[ny][nx] == 1 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					distance[ny][nx] = distance[y][x] + 1; // 거리 갱신
					queue.offer(new Position(ny, nx));
				}
			}
		}
	}
	
	/**
	 * 좌표가 유효한 범위 내에 있는지 확인
	 */
	private static boolean isValid(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}
	
	/**
	 * 위치 정보를 저장하는 클래스
	 */
	static class Position {
		int y, x;
		
		Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}