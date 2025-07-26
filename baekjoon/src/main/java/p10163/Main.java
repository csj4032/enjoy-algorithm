/**
 * 백준 10163번: 색종이
 * https://www.acmicpc.net/problem/10163
 * 
 * 문제 설명:
 * n개의 색종이가 주어진 순서대로 좌표평면에 놓인다.
 * 각 색종이의 보이는 부분의 넓이를 구하는 문제
 * 나중에 놓인 색종이가 먼저 놓인 색종이를 덮을 수 있다.
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner 사용)
 * - 2차원 배열 활용
 * - 중첩 반복문 (이중/삼중 for문)
 * - 좌표계 이해
 * - 시뮬레이션 (색종이 겹치기)
 * 
 * 시간복잡도: O(n * area + 101^2) - n개 색종이 처리 + 전체 영역 카운팅
 */
package p10163;

import java.util.Scanner;

public class Main {

	// 101x101 크기의 좌표평면 (0~100 좌표 사용)
	static int[][] board = new int[101][101];

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();  // 색종이 개수
		var sb = new StringBuilder();
		
		// n개의 색종이를 순서대로 배치
		for (int i = 1; i <= n; i++) {
			int x = sc.nextInt();  // 왼쪽 아래 x좌표
			int y = sc.nextInt();  // 왼쪽 아래 y좌표
			int w = sc.nextInt();  // 가로 길이
			int h = sc.nextInt();  // 세로 길이
			color(x, y, w, h, i);  // i번째 색종이로 영역을 칠함
		}

		// 각 색종이의 보이는 영역 계산
		for (int k = 1; k <= n; k++) {
			var t = 0;
			// 전체 좌표평면을 순회하며 k번째 색종이 영역 카운팅
			for (int i = 0; i <= 100; i++) {
				for (int j = 0; j <= 100; j++) {
					if (board[i][j] == k) {
						t++;
					}
				}
			}
			sb.append(t + "\n");
		}
		System.out.println(sb);
	}

	// 주어진 영역을 i번째 색종이로 칠하는 함수
	private static void color(int x, int y, int w, int h, int i) {
		for (int j = y; j < y + h; j++) {      // 세로 방향
			for (int k = x; k < x + w; k++) {  // 가로 방향
				board[j][k] = i;  // i번째 색종이로 표시
			}
		}
	}
}
