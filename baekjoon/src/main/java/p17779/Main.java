package p17779;

import java.util.Scanner;

/**
 * 제목 : 게리맨더링 2
 * 링크 : https://www.acmicpc.net/problem/17779
 * 분류 : 구현, 브루트포스 알고리즘, 시뮬레이션
 */
public class Main {

	static int n;
	static int minn = Integer.MAX_VALUE;
	static int map[][];
	static int map2[][];
	static int xyd1d2[] = new int[4];

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		map2 = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(0);
		System.out.println(minn);
	}

	private static void dfs(int depth) {
		if (depth >= 4) {
			var s1 = 0;
			var s2 = 0;
			var s3 = 0;
			var s4 = 0;
			var s5 = 0;
			var x = xyd1d2[0];
			var y = xyd1d2[1];
			var d1 = xyd1d2[2];
			var d2 = xyd1d2[3];
			map2 = new int[n][n];

			if (x < x + d1 + d2 && x + d1 + d2 <= n && 1 <= y - d1 && y - d1 < y && y < y + d2 && y + d2 <= n) {
				check(x, y, d1, d2);
				for (int r = 1; r <= n; r++) {
					for (int c = 1; c <= n; c++) {
						if ((r == x && c == y) || map2[r - 1][c - 1] == 5) {
							s5 += map[r - 1][c - 1];
						} else if (r < x + d1 && c <= y) {
							if (map2[r - 1][c - 1] != 5) s1 += map[r - 1][c - 1];
						} else if (r <= x + d2 && y < c) {
							if (map2[r - 1][c - 1] != 5) s2 += map[r - 1][c - 1];
						} else if ((x + d1) <= r && c < (y - d1 + d2)) {
							if (map2[r - 1][c - 1] != 5) s3 += map[r - 1][c - 1];
						} else if ((x + d2) < r && (y - d1 + d2) <= c) {
							if (map2[r - 1][c - 1] != 5) s4 += map[r - 1][c - 1];
						}
					}
				}
				var max = Math.max(Math.max(Math.max(Math.max(s1, s2), s3), s4), s5);
				var min = Math.min(Math.min(Math.min(Math.min(s1, s2), s3), s4), s5);
				minn = Math.min(max - min, minn);
			}
			return;
		}
		for (int i = 1; i <= n; i++) {
			xyd1d2[depth] = i;
			dfs(depth + 1);
		}
	}

	private static void display(int[][] map) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void check(int x, int y, int d1, int d2) {
		var xx = x;
		var yy = y;
		while (xx <= x + d1 && yy < y + d2) {
			map2[xx - 1][yy - 1] = 5;
			xx++;
			yy--;
		}

		xx = x;
		yy = y;
		while (xx <= x + d2 && yy <= y + d2) {
			map2[xx - 1][yy - 1] = 5;
			xx++;
			yy++;
		}

		xx = x + d1;
		yy = y - d1;
		while (xx <= x + d1 + d2 && yy <= y - d1 + d2) {
			map2[xx - 1][yy - 1] = 5;
			xx++;
			yy++;
		}

		xx = x + d2;
		yy = y + d2;
		while (xx <= x + d2 + d1 && yy > y + d2 - d1) {
			map2[xx - 1][yy - 1] = 5;
			xx++;
			yy--;
		}

		for (int i = 1; i <= n; i++) {
			var s = 0;
			var e = 0;
			for (int j = 1; j <= n; j++) {
				if (e == 0 && map2[i - 1][j - 1] == 5) s = j;
				if (s != 0 && map2[i - 1][j - 1] == 5) e = j;
			}
			for (int j = s; j < e; j++) map2[i - 1][j - 1] = 5;
		}
	}
}