package p10026;

import java.util.Scanner;

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
		for (int i = 0; i < n; i++) {
			var w = sc.next().split("");
			for (int j = 0; j < n; j++) {
				board[i][j] = w[j];
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (board[j][k].equals(RGB[i]) && !visitor[j][k]) {
						dfs(RGB[i], j, k);
						r++;
					}
				}
			}
		}

		visitor = new boolean[101][101];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (RGB2[i].contains(board[j][k]) && !visitor[j][k]) {
						dfs2(RGB2[i], j, k);
						g++;
					}
				}
			}
		}

		System.out.println((r + " " + g));
	}

	private static void dfs(String w, int i, int j) {
		if (visitor[i][j] && !board[i][j].equals(w)) return;
		visitor[i][j] = true;
		for (int k = 0; k < 4; k++) {
			var y = i + direct[k][0];
			var x = j + direct[k][1];
			if (0 <= y && y < n && 0 <= x && x < n && board[y][x].equals(w) && !visitor[y][x]) {
				dfs(w, y, x);
			}
		}
	}

	private static void dfs2(String w, int i, int j) {
		if (visitor[i][j] && !w.contains(board[i][j])) return;
		visitor[i][j] = true;
		for (int k = 0; k < 4; k++) {
			var y = i + direct[k][0];
			var x = j + direct[k][1];
			if (0 <= y && y < n && 0 <= x && x < n && w.contains(board[y][x]) && !visitor[y][x]) {
				dfs2(w, y, x);
			}
		}
	}

}