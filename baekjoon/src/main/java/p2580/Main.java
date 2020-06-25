package p2580;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 제목 : 스도쿠
 * 링크 : https://www.acmicpc.net/problem/2580
 * 분류 : 백트래킹
 */
public class Main {

	static int[][] board = new int[9][9];
	static List<int[]> positions = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = sc.nextInt();
				if (board[i][j] == 0) {
					positions.add(new int[]{i, j});
				}
			}
		}
		sudoku(0);
		System.out.println(sb.toString());
	}

	private static void sudoku(int k) {
		if (k == positions.size()) {
			for (int i = 0; i < 9; i++) {
				var padding = " ";
				for (int j = 0; j < 9; j++) {
					if (j == 8) padding = "";
					sb.append(board[i][j] + padding);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (promising(k, i)) {
				board[positions.get(k)[0]][positions.get(k)[1]] = i;
				sudoku(k + 1);
				board[positions.get(k)[0]][positions.get(k)[1]] = 0;
			}
		}
	}

	private static boolean promising(int k, int n) {
		for (int i = 0; i < 9; i++) {
			if (n == board[positions.get(k)[0]][i]) {
				return false;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (n == board[i][positions.get(k)[1]]) {
				return false;
			}
		}
		int p = getPosition(positions.get(k)[0]);
		int q = getPosition(positions.get(k)[1]);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (n == board[p + i][q + j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static int getPosition(int i) {
		if (0 <= i && i < 3) return 0;
		if (3 <= i && i < 6) return 3;
		return 6;
	}
}