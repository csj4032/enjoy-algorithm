package p17144;

import java.util.Scanner;

/**
 * 제목 : 미세먼지 안녕!
 * 링크 : https://www.acmicpc.net/problem/17144
 * 분류 : 구현, 브루트포스 알고리즘, 시계 반시계 배열 회전
 */
public class Main {

	static int d[][] = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
	static int d2[][] = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int map[][];
	static int map2[][];
	static int r;
	static int c;
	static int t;
	static int k;
	static int x;
	static int y;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		t = sc.nextInt();
		map = new int[r][c];
		map2 = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = sc.nextInt();
				map2[i][j] = map[i][j];
				if (map[i][j] == -1) {
					y = i;
					x = j;
				}
			}
		}

		while (t-- > 0) {
			spread();
			clean();
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				k += map[i][j];
			}
		}

		System.out.println(k + 2);
	}

	private static void clean() {
		var map3 = new int[y][c];
		var map33 = new int[y][c];
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < c; j++) {
				map3[i][j] = map[i][j];
				map33[i][j] = map[i][j];
			}
		}

		var map4 = new int[r - y][c];
		var map44 = new int[r - y][c];
		for (int i = y; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map4[i - y][j] = map[i][j];
				map44[i - y][j] = map[i][j];
			}
		}

		var ddd = 0;
		var yy = y - 1;
		var xx = x;
		while (true) {
			if (xx + d[ddd][1] >= c || yy + d[ddd][0] < 0 || xx + d[ddd][1] < 0 || yy + d[ddd][0] > y) ddd++;
			var yyy = yy + d[ddd][0];
			var xxx = xx + d[ddd][1];
			if (y - 1 == yyy && x == xxx) break;
			map3[yyy][xxx] = map33[yy][xx] == -1 ? 0 : map33[yy][xx];
			yy = yyy;
			xx = xxx;
		}

		var dddd = 0;
		var yy2 = 0;
		var xx2 = x;
		while (true) {
			if (xx2 + d2[dddd][1] >= c || yy2 + d2[dddd][0] < 0 || xx2 + d2[dddd][1] < 0 || yy2 + d2[dddd][0] >= r - y) {
				dddd++;
			}
			var yyy = yy2 + d2[dddd][0];
			var xxx = xx2 + d2[dddd][1];
			if (0 == yyy && x == xxx) break;
			map4[yyy][xxx] = map44[yy2][xx2] == -1 ? 0 : map44[yy2][xx2];
			yy2 = yyy;
			xx2 = xxx;
		}

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = map3[i][j];
				map2[i][j] = map3[i][j];
			}
		}

		for (int i = 0; i < r - y; i++) {
			for (int j = 0; j < c; j++) {
				map[i + y][j] = map4[i][j];
				map2[i + y][j] = map4[i][j];
			}
		}
	}

	private static void spread() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				var tt = map[i][j];
				if (tt >= 0) {
					for (int k = 0; k < 4; k++) {
						var rr = d[k][0] + i;
						var cc = d[k][1] + j;
						if (rr >= 0 && rr < r && cc >= 0 && cc < c && map[rr][cc] >= 0) {
							map2[i][j] += (map[rr][cc] / 5);
						}
					}
				}
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				var tt = map[i][j];
				var dd = 0;
				if (tt >= 0) {
					for (int k = 0; k < 4; k++) {
						var rr = d[k][0] + i;
						var cc = d[k][1] + j;
						if (rr >= 0 && rr < r && cc >= 0 && cc < c && map[rr][cc] >= 0) {
							dd++;
						}
					}
				}
				map[i][j] = map2[i][j] - ((map[i][j] / 5) * dd);
			}
		}
	}

	private static void display(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}