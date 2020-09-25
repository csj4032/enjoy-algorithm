package p12094;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static int n;
	static int m = 0;
	static int max;
	static int limit;
	static int sum;
	static int[][] map;
	static int[] dy = new int[]{-1, 0, 1, 0};
	static int[] dx = new int[]{0, 1, 0, -1};
	static boolean[][] lock;
	static boolean[][] visitor;
	static Map<Integer, Integer> counter = new HashMap();

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visitor = new boolean[10][4];
		lock = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				var cell = sc.nextInt();
				map[i][j] = cell;
				if (counter.containsKey(cell)) {
					counter.put(cell, counter.get(cell) + 1);
				} else {
					counter.put(cell, 1);
				}
			}
		}
		dfs(0, map);
		System.out.println(max);
	}

	private static void dfs(int depth, int[][] map) {
		if (depth > 9) return;
		for (int i = 0; i < 4; i++) {
			if (!visitor[depth][i]) {
				visitor[depth][i] = true;
				var copyMap = copyMap(map);
				move(i, copyMap);
				max = Math.max(max, max(copyMap));
				dfs(depth + 1, copyMap);
				visitor[depth][i] = false;
			}
		}
	}

	private static boolean isAllStay(int[][] map, int direct) {
		var stay = true;
		if (direct == 0) {
			outer1:
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if ((map[i][j] == map[i - 1][j] && map[i][j] != 0) || (map[i][j] != map[i - 1][j] && map[i - 1][j] == 0)) {
						stay = false;
						break outer1;
					}
				}
			}
		} else if (direct == 1) {
			outer2:
			for (int i = n - 1; i >= 1; i--) {
				for (int j = 0; j < n; j++) {
					if ((map[j][i] == map[j][i - 1] && map[i][j] != 0) || (map[j][i] != map[j][i - 1] && map[j][i - 1] == 0)) {
						stay = false;
						break outer2;
					}
				}
			}
		} else if (direct == 2) {
			outer3:
			for (int i = n - 1; i >= 1; i--) {
				for (int j = 0; j < n; j++) {
					if ((map[i][j] == map[i - 1][j] && map[i][j] != 0) || (map[i][j] != map[i - 1][j] && map[i - 1][j] == 0)) {
						stay = false;
						break outer3;
					}
				}
			}
		} else if (direct == 3) {
			outer4:
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n; j++) {
					if ((map[j][i] == map[j][i + 1] && map[i][j] != 0) || (map[j][i] != map[j][i + 1] && map[i][j] == 0)) {
						stay = false;
						break outer4;
					}
				}
			}
		}
		return stay;
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
			map[i][ddx] <<= 1;
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
				max = max < map[i][j] ? map[i][j] : max;
			}
		}
		return max;
	}

	private static int[][] copyMap(int[][] src) {
		var target = new int[n][n];
		for (int i = 0; i < n; i++) System.arraycopy(src[i], 0, target[i], 0, src[i].length);
		return target;
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
/*
20
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 8


16
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
 * <p>
 * <p>
 * 2 4
 * 123456789
 * 2 4 8 16 32 64 128 512 1024
 * 1 2 3 4  5  6  7   8   9
512


 */