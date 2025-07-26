package p9663;

import java.util.Scanner;

/**
 * 제목 : N-Queen
 * 링크 : https://www.acmicpc.net/problem/9663
 * 분류 : 브루트포스 알고리즘, 백트래킹
 * 
 * 문제 해설:
 * - N×N 체스판에 N개의 퀸을 서로 공격할 수 없게 놓는 방법의 수를 구하는 문제
 * - 퀸은 가로, 세로, 대각선으로 이동할 수 있어 이 방향들로 다른 퀸과 겹치면 안됨
 * - 대표적인 백트래킹 문제로 가지치기(pruning)를 통한 최적화가 핵심
 * 
 * 해결 방법:
 * - 1차원 배열 cols[i] = j: i번째 행에 놓인 퀸의 열 위치가 j
 * - promising 함수로 현재 배치가 유효한지 검사:
 *   1) 같은 열에 있는지 검사: cols[i] == cols[row]
 *   2) 대각선에 있는지 검사: |row-i| == |cols[row]-cols[i]|
 * - 백트래킹으로 가능한 모든 경우의 수 탐색
 * 
 * 시간복잡도: O(N!) (백트래킹으로 크게 단축됨)
 */
public class Main {

	static int size;
	static int count;
	static int[] cols;

	public static void main(String[] args) {
		solve(new Scanner(System.in).nextInt());
	}

	private static void solve(int input) {
		size = input;
		cols = new int[size + 1];  // 1-indexed: cols[i] = i번째 행의 퀸이 놓인 열
		recursive(0);              // 0번째 행부터 시작 (실제로는 1번째 행부터)
		System.out.println(count);
	}

	/**
	 * 백트래킹을 이용한 N-Queen 해결
	 * @param row 현재 배치하려는 행 번호
	 * @return 현재 배치가 성공했는지 여부 (실제로는 사용되지 않음)
	 */
	private static boolean recursive(int row) {
		// 현재 배치가 유효하지 않으면 백트래킹
		if (!promising(row)) {
			return false;
		} 
		// 모든 행에 퀸을 성공적으로 배치했으면 경우의 수 증가
		else if (row == size) {
			count++;
			return true;
		}

		// row+1번째 행의 각 열에 퀸을 놓아보기
		for (int i = 1; i <= size; i++) {
			cols[row + 1] = i;          // (row+1, i) 위치에 퀸 배치
			recursive(row + 1);         // 다음 행으로 재귀 호출
		}
		return false;
	}

	/**
	 * 현재 row까지의 퀸 배치가 유효한지 검사
	 * @param row 검사할 행 번호
	 * @return 유효하면 true, 아니면 false
	 */
	private static boolean promising(int row) {
		// 1번째 행부터 (row-1)번째 행까지의 퀸들과 충돌 검사
		for (int i = 1; i < row; i++) {
			// 같은 열에 있는지 검사
			if (cols[i] == cols[row]) return false;
			
			// 대각선에 있는지 검사 (행의 차이 == 열의 차이)
			if ((row - i) == Math.abs(cols[row] - cols[i])) return false;
		}
		return true;
	}
}