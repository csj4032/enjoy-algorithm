package p ;

import java.util.Scanner;

public class Main {

	static int[][] board = new int[101][101];

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			color(x, y, w, h, i);
		}

		for (int k = 1; k <= n; k++) {
			var t = 0;
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

	private static void color(int x, int y, int w, int h, int i) {
		for (int j = y; j < y + h; j++) {
			for (int k = x; k < x + w; k++) {
				board[j][k] = i;
			}
		}
	}
}
