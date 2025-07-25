package p1149;

import java.util.Scanner;

/**
 * 제목 : RGB거리
 * 링크 : https://www.acmicpc.net/problem/1149
 * 분류 : 다이나믹 프로그래밍
 * 
 * 문제 해설:
 * - N개의 집을 빨강(R), 초록(G), 파랑(B) 중 하나의 색으로 칠하는 최소 비용을 구하는 문제
 * - 제약 조건: 인접한 두 집은 같은 색으로 칠할 수 없음
 * - 각 집마다 R, G, B로 칠하는 비용이 주어짐
 * 
 * DP 설계:
 * - l[i][j] = i번째 집을 j색으로 칠했을 때의 최소 비용 (j: 0=R, 1=G, 2=B)
 * - 점화식: l[i][j] = min(l[i-1][k]) + m[i][j] (k ≠ j인 모든 k에 대해)
 *   즉, 이전 집은 현재 집과 다른 색으로 칠해야 하므로 나머지 2가지 색 중 최소값 선택
 * 
 * 시간복잡도: O(N), 공간복잡도: O(N)
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] m = new int[n + 1][3];  // m[i][j] = i번째 집을 j색으로 칠하는 비용
		int[][] l = new int[n + 1][3];  // l[i][j] = i번째 집을 j색으로 칠했을 때까지의 최소 비용

		// 0번째는 더미 데이터 (비용 0)
		m[0][0] = m[0][1] = m[0][2] = 0;
		l[0][0] = l[0][1] = l[0][2] = 0;

		// 각 집의 색칠 비용 입력
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 3; j++) {
				m[i][j] = sc.nextInt();
			}
		}

		// DP 계산: 각 집마다 3가지 색으로 칠하는 경우의 최소 비용 계산
		for (int i = 1; i <= n; i++) {
			// i번째 집을 빨강(0)으로 칠하는 경우: 이전 집은 초록(1) 또는 파랑(2)
			l[i][0] = Math.min(l[i - 1][1], l[i - 1][2]) + m[i][0];
			// i번째 집을 초록(1)으로 칠하는 경우: 이전 집은 빨강(0) 또는 파랑(2)
			l[i][1] = Math.min(l[i - 1][0], l[i - 1][2]) + m[i][1];
			// i번째 집을 파랑(2)으로 칠하는 경우: 이전 집은 빨강(0) 또는 초록(1)
			l[i][2] = Math.min(l[i - 1][0], l[i - 1][1]) + m[i][2];
		}

		// 마지막 집을 3가지 색으로 칠했을 때의 최소 비용
		System.out.println(Math.min(Math.min(l[n][0], l[n][1]), l[n][2]));
	}
}