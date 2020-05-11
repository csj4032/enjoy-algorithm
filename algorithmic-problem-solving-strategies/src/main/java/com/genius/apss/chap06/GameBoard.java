package com.genius.apss.chap06;

import java.util.Scanner;

public class GameBoard {

	static int[][][] b = {
			{{0, 0}, {1, 0}, {0, 1}},
			{{0, 0}, {0, 1}, {1, 1}},
			{{0, 0}, {1, 0}, {1, 1}},
			{{0, 0}, {1, 0}, {1, -1}}
	};

	static int[][] m;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var c = sc.nextInt();

		for (int k = 0; k < c; k++) {
			var h = sc.nextInt();
			var w = sc.nextInt();
			m = new int[h][w];
			for (int i = 0; i < h; i++) {
				String[] str = sc.next().split("");
				for (int j = 0; j < w; j++) {
					m[i][j] = str[j].equals(".") ? 0 : 1;
				}
			}
			System.out.println(cover(m));
		}
		sc.close();
	}

	private static int cover(int[][] m) {
		int y = -1;
		int x = -1;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == 0) {
					y = i;
					x = j;
					break;
				}
			}
			if (y != -1) break;
		}
		if (y == -1) return 1;

		int ret = 0;
		for (int i = 0; i < 4; i++) {
			if (set(m, y, x, i, 1)) {
				ret += cover(m);
			}
			set(m, y, x, i, -1);
		}
		return ret;
	}

	private static boolean set(int[][] m, int y, int x, int type, int delta) {
		boolean ok = true;
		for (int i = 0; i < 3; i++) {
			int ny = y + b[type][i][0];
			int nx = x + b[type][i][1];
			if (ny < 0 || ny >= m.length || nx < 0 || nx >= m[0].length) {
				ok = false;
			} else if ((m[ny][nx] += delta) > 1) {
				ok = false;
			}
		}
		return ok;
	}
}