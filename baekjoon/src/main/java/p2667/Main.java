package p2667;

import java.util.*;

/**
 * 백준 2667번: 단지번호붙이기 (Silver 1)
 * https://www.acmicpc.net/problem/2667
 * 
 * 문제 분류: 그래프 탐색, DFS, BFS, 연결 컴포넌트
 * 핵심 알고리즘: DFS를 이용한 연결 컴포넌트 크기 계산
 * 
 * 해결 접근 방법:
 * 1. 지도를 2차원 배열로 입력받아 저장
 * 2. 모든 위치를 순회하면서 집(1)이면서 방문하지 않은 곳에서 DFS 시작
 * 3. DFS로 연결된 모든 집을 방문하며 단지 내 집의 수를 계산
 * 4. 각 단지의 크기를 리스트에 저장 후 오름차순 정렬하여 출력
 * 
 * 시간복잡도: O(N²) - 모든 칸을 최대 한 번씩 방문
 * 공간복잡도: O(N²) - 지도 저장 공간
 * 
 * 그래프 이론 개념:
 * - 연결 컴포넌트의 크기 구하기
 * - 4방향 탐색 (상하좌우)
 * - 방문 처리를 통한 중복 탐색 방지
 */
public class Main {

	private static int[][] map; // 지도 (1: 집, 0: 빈 땅)
	private static int N; // 지도 크기
	private static List<Integer> complexSizes = new ArrayList<>(); // 각 단지의 크기
	private static int currentComplexSize; // 현재 탐색 중인 단지의 크기
	
	// 상하좌우 4방향 이동을 위한 배열
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		// 지도 입력 (한 줄씩 문자열로 읽어서 각 자리수를 분리)
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		// 모든 위치에서 DFS 탐색 시도
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 집이 있고 아직 방문하지 않은 위치라면 (map[i][j] == 1)
				if (map[i][j] == 1) {
					currentComplexSize = 0; // 새로운 단지 시작
					dfs(i, j); // 연결된 모든 집을 탐색
					complexSizes.add(currentComplexSize); // 단지 크기 저장
				}
			}
		}
		
		// 결과 출력
		System.out.println(complexSizes.size()); // 총 단지 수
		complexSizes.stream()
				.sorted() // 오름차순 정렬
				.forEach(System.out::println); // 각 단지의 크기 출력
	}

	/**
	 * 깊이 우선 탐색으로 연결된 집들을 모두 방문하며 단지 크기 계산
	 * 
	 * @param y 현재 행 위치
	 * @param x 현재 열 위치
	 */
	private static void dfs(int y, int x) {
		// 현재 집을 방문 처리 (0으로 변경)
		map[y][x] = 0;
		currentComplexSize++; // 단지 내 집의 수 증가
		
		// 4방향으로 탐색
		for (int dir = 0; dir < 4; dir++) {
			int ny = y + dy[dir]; // 새로운 행 위치
			int nx = x + dx[dir]; // 새로운 열 위치
			
			// 범위를 벗어나지 않고, 집이 있다면 (map[ny][nx] == 1)
			if (isValid(ny, nx) && map[ny][nx] == 1) {
				dfs(ny, nx); // 재귀적으로 탐색 계속
			}
		}
	}
	
	/**
	 * 좌표가 유효한 범위 내에 있는지 확인
	 */
	private static boolean isValid(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
}