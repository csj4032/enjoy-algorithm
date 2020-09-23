package p12100;

import java.util.Scanner;

public class Main {

	static int n;
	static int m = 0;
	static int max;
	static int[][] map;
	static int[] dy = new int[]{-1, 0, 1, 0};
	static int[] dx = new int[]{0, 1, 0, -1};
	static boolean[][] lock;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(0, map);
		System.out.println(max);
	}

	private static void dfs(int depth, int[][] map) {
		if (depth > 4) return;
		for (int i = 0; i < 4; i++) {
			var copyMap = copyMap(map);
			move(i, copyMap);
			max = Math.max(max, max(copyMap));
			dfs(depth + 1, copyMap);
		}
	}

	private static void move(int direct, int[][] map) {
		var c = 0;
		lock = new boolean[n][n];
		while (true) {
			if (c == n) break;
			if (direct == 0) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						top(map, i, j);
					}
				}
			} else if (direct == 1) {
				for (int i = 0; i < n; i++) {
					for (int j = n - 1; j >= 0; j--) {
						right(map, i, j);
					}
				}
			} else if (direct == 2) {
				for (int i = n - 1; i >= 0; i--) {
					for (int j = 0; j < n; j++) {
						bottom(map, i, j);
					}
				}
			} else if (direct == 3) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						left(map, i, j);
					}
				}
			}
			c++;
		}
	}

	private static void left(int[][] map, int i, int j) {
		var ddx = j + dx[3];
		if (ddx >= m && map[i][j] != 0) copyCol(map, i, j, ddx);
	}

	private static void bottom(int[][] map, int i, int j) {
		var ddy = i + dy[2];
		if (ddy < n && map[i][j] != 0) copyRow(map, i, j, ddy);
	}

	private static void right(int[][] map, int i, int j) {
		var ddx = j + dx[1];
		if (ddx < n && map[i][j] != 0) copyCol(map, i, j, ddx);
	}

	private static void top(int[][] map, int i, int j) {
		var ddy = i + dy[0];
		if (ddy >= m && map[i][j] != 0) copyRow(map, i, j, ddy);
	}

	private static void copyCol(int[][] map, int i, int j, int ddx) {
		copyCell(map, i, j, ddx, map[i], lock[i]);
	}

	private static void copyRow(int[][] map, int i, int j, int ddy) {
		copyCell(map, ddy, j, j, map[i], lock[i]);
	}

	private static void copyCell(int[][] map, int i, int j, int ddx, int[] ints, boolean[] booleans) {
		if (map[i][ddx] == ints[j] && !lock[i][ddx] && !booleans[j]) {
			lock[i][ddx] = true;
			map[i][ddx] = map[i][ddx] + ints[j];
			ints[j] = 0;
		} else {
			if (map[i][ddx] == 0) {
				map[i][ddx] = ints[j];
				ints[j] = 0;
			}
		}
	}

	private static int max(int[][] map) {
		var max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, map[i][j]);
			}
		}
		return max;
	}

	private static int[][] copyMap(int[][] map) {
		var copyMap = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		return copyMap;
	}

	private static void display(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
}