package p10026;

import java.util.Scanner;

/**
 * 제목 : 적록색약
 * 링크 : https://www.acmicpc.net/problem/10026
 * 분류 : 그래프 탐색, DFS, BFS
 * 
 * 문제 해설:
 * - 적록색약은 빨간색과 초록색을 구분하지 못함
 * - 일반인과 적록색약이 보는 구역의 개수를 각각 구해야 함
 * - DFS를 사용하여 연결된 같은 색깔 영역을 찾음
 * 
 * 해결 방법:
 * 1) 일반인: R, G, B를 각각 다른 색으로 인식하여 DFS 실행
 * 2) 적록색약: R과 G를 같은 색(RG)으로, B를 다른 색으로 인식하여 DFS 실행
 */
public class Main {

	private static int n;
	private static int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	private static String[] RGB = {"R", "G", "B"};
	private static String[] RGB2 = {"RG", "B"};
	private static String[][] board = new String[101][101];
	private static boolean[][] visitor = new boolean[101][101];
	private static int r;
	private static int g;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		
		// 입력: N×N 격자의 색깔 정보를 저장
		for (int i = 0; i < n; i++) {
			var w = sc.next().split("");
			for (int j = 0; j < n; j++) {
				board[i][j] = w[j];
			}
		}

		// 일반인이 보는 구역 개수 계산 (R, G, B 각각 구분)
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (board[j][k].equals(RGB[i]) && !visitor[j][k]) {
						dfs(RGB[i], j, k);  // 같은 색깔로 연결된 영역 탐색
						r++;  // 구역 개수 증가
					}
				}
			}
		}

		// 적록색약이 보는 구역 개수 계산을 위해 방문 배열 초기화
		visitor = new boolean[101][101];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (RGB2[i].contains(board[j][k]) && !visitor[j][k]) {
						dfs2(RGB2[i], j, k);  // RG를 같은 색으로, B를 다른 색으로 구분
						g++;  // 구역 개수 증가
					}
				}
			}
		}

		System.out.println((r + " " + g));  // 일반인과 적록색약이 보는 구역 수 출력
	}

	/**
	 * 일반인용 DFS: 정확히 같은 색깔만 연결된 것으로 인식
	 * @param w 찾고자 하는 색깔 (R, G, B 중 하나)
	 * @param i, j 현재 탐색 중인 좌표
	 */
	private static void dfs(String w, int i, int j) {
		if (visitor[i][j] && !board[i][j].equals(w)) return;
		visitor[i][j] = true;  // 현재 위치 방문 처리
		
		// 상하좌우 4방향 탐색
		for (int k = 0; k < 4; k++) {
			var y = i + direct[k][0];
			var x = j + direct[k][1];
			// 경계 검사 및 같은 색깔이면서 방문하지 않은 곳 탐색
			if (0 <= y && y < n && 0 <= x && x < n && board[y][x].equals(w) && !visitor[y][x]) {
				dfs(w, y, x);
			}
		}
	}

	/**
	 * 적록색약용 DFS: R과 G를 같은 색으로, B를 다른 색으로 인식
	 * @param w 찾고자 하는 색깔 그룹 ("RG" 또는 "B")
	 * @param i, j 현재 탐색 중인 좌표
	 */
	private static void dfs2(String w, int i, int j) {
		if (visitor[i][j] && !w.contains(board[i][j])) return;
		visitor[i][j] = true;  // 현재 위치 방문 처리
		
		// 상하좌우 4방향 탐색
		for (int k = 0; k < 4; k++) {
			var y = i + direct[k][0];
			var x = j + direct[k][1];
			// 경계 검사 및 같은 색깔 그룹이면서 방문하지 않은 곳 탐색
			if (0 <= y && y < n && 0 <= x && x < n && w.contains(board[y][x]) && !visitor[y][x]) {
				dfs2(w, y, x);
			}
		}
	}

}