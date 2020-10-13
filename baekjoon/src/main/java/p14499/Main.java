package p14499;

import java.util.Scanner;

public class Main {

	static int[][] map;
	static int[][] dice = new int[7][4];

	static {
		dice[0] = new int[]{0, 0, 0, 0};
		dice[1] = new int[]{3, 4, 2, 5};
		dice[2] = new int[]{3, 4, 6, 1};
		dice[3] = new int[]{1, 6, 2, 5};
		dice[4] = new int[]{6, 1, 2, 5};
		dice[5] = new int[]{4, 3, 1, 6};
		dice[6] = new int[]{4, 3, 5, 2};
	}

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.nextInt();
		var x = sc.nextInt();
		var y = sc.nextInt();
		var k = sc.nextInt();
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		var current = 0;
		for (int i = 0; i < k; i++) {
			var direct = sc.nextInt();
			current = dice[current][direct];
		}
	}
}