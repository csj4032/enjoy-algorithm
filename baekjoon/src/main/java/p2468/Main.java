package p2468;

import java.util.Scanner;

public class Main {

	private static int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	private static int[][] board = new int[101][101];
	private static boolean[][] visitor;
	private static int n;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		var m = 0;
		for (int t = 0; t < 101; t++) {
			visitor = new boolean[101][101];
			var q = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] > t && !visitor[i][j]) {
						dfs(i, j, t);
						q++;
					}
				}
			}
			m = Math.max(q, m);
		}
		System.out.println(m);
	}

	private static void dfs(int i, int j, int t) {
		if (visitor[i][j]) return;
		for (int k = 0; k < 4; k++) {
			var y = i + direct[k][0];
			var x = j + direct[k][1];
			if (0 <= y && y < 101 && 0 <= x && x < 101 && board[y][x] > t) {
				visitor[i][j] = true;
				dfs(y, x, t);
			}
		}
	}
}
