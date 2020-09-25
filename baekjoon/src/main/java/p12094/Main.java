package p12094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int n;
	static int max;
	static int[][] map;
	static int[] depth_max;

	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		depth_max = new int[11];
		for (int i = 0; i < n; i++) {
			var st = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st[j]);
			}
		}
		dfs(0);
		System.out.println(max);
	}

	private static void dfs(int depth) {
		var d_max = max();
		if (depth_max[depth] >= d_max) {
			return;
		}
		if (depth == 10) {
			max = Math.max(d_max, max);
			var temp = max;
			while (depth > 0) {
				depth_max[depth--] = temp;
				temp /= 2;
			}
			return;
		}
		var tempMap = copyMap(map);
		for (int i = 0; i < 4; i++) {
			move(i);
			max = Math.max(max, max());
			if (isSameMap(map, tempMap)) continue;
			dfs(depth + 1);
			map = copyMap(tempMap);
		}
	}

	private static boolean isSameMap(int[][] map, int[][] copyMap) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != copyMap[i][j]) return false;
			}
		}
		return true;
	}

	private static int max() {
		var max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = max > map[i][j] ? max : map[i][j];
			}
		}
		return max;
	}

	private static void move(int direct) {
		var queue = new LinkedList<Integer>();
		if (direct == 0) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[j][i] > 0) {
						queue.addLast(map[j][i]);
						map[j][i] = 0;
					}
				}
				var idx = 0;
				while (!queue.isEmpty()) {
					var num = queue.peek();
					queue.pop();
					if (map[idx][i] == 0) {
						map[idx][i] = num;
					} else if (map[idx][i] == num) {
						map[idx++][i] += num;
					} else {
						map[++idx][i] = num;
					}
				}
			}
		} else if (direct == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = n - 1; j >= 0; j--) {
					if (map[i][j] > 0) {
						queue.addLast(map[i][j]);
						map[i][j] = 0;
					}
				}
				var idx = n - 1;
				while (!queue.isEmpty()) {
					var num = queue.peek();
					queue.pop();
					if (map[i][idx] == 0) {
						map[i][idx] = num;
					} else if (map[i][idx] == num) {
						map[i][idx--] += num;
					} else {
						map[i][--idx] = num;
					}
				}
			}
		} else if (direct == 2) {
			for (int i = 0; i < n; i++) {
				for (int j = n - 1; j >= 0; j--) {
					if (map[j][i] > 0) {
						queue.addLast(map[j][i]);
						map[j][i] = 0;
					}
				}
				var idx = n - 1;
				while (!queue.isEmpty()) {
					var num = queue.peek();
					queue.pop();
					if (map[idx][i] == 0) {
						map[idx][i] = num;
					} else if (map[idx][i] == num) {
						map[idx--][i] += num;
					} else {
						map[--idx][i] = num;
					}
				}
			}
		} else if (direct == 3) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] > 0) {
						queue.addLast(map[i][j]);
						map[i][j] = 0;
					}
				}
				var idx = 0;
				while (!queue.isEmpty()) {
					var num = queue.peek();
					queue.pop();
					if (map[i][idx] == 0) {
						map[i][idx] = num;
					} else if (map[i][idx] == num) {
						map[i][idx++] += num;
					} else {
						map[i][++idx] = num;
					}
				}
			}
		}
	}

	private static int[][] copyMap(int[][] src) {
		var dest = new int[n][n];
		for (int i = 0; i < src.length; i++) {
			System.arraycopy(src[i], 0, dest[i], 0, src[0].length);
		}
		return dest;
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

3
2 2 2
2 2 2
2 2 2

20
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024

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

8
2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2

4
1024 0 0 1024
1024 0 0 1024
1024 0 0 1024
1024 0 0 1024

 * <p>
 * <p>
 * 2 4
 * 123456789
 * 2 4 8 16 32 64 128 512 1024
 * 1 2 3 4  5  6  7   8   9
512


 */