package p14499;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 제목 : 주사위 굴리기
 * 링크 : https://www.acmicpc.net/problem/14499
 * 분류 : 구현, 시뮬레이션
 */
public class Main {

	static int[][] map;
	static int[][] dice = new int[4][3];
	static int[][][] direct = new int[2][4][2];
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	static {

		dice[0] = new int[]{0, 2, 0};
		dice[1] = new int[]{4, 1, 3};
		dice[2] = new int[]{0, 5, 0};
		dice[3] = new int[]{0, 6, 0};

		direct[0][0] = new int[]{0, 1};
		direct[0][1] = new int[]{1, 1};
		direct[0][2] = new int[]{2, 1};
		direct[0][3] = new int[]{3, 1};

		direct[1][0] = new int[]{1, 1};
		direct[1][1] = new int[]{1, 2};
		direct[1][2] = new int[]{3, 1};
		direct[1][3] = new int[]{1, 0};
	}

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.nextInt();
		var y = sc.nextInt();
		var x = sc.nextInt();
		var k = sc.nextInt();
		map = new int[n][m];
		result = new int[7];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < k; i++) {
			var direct = sc.nextInt();
			if (direct == 1) {
				x++;
				if (x >= m) {
					x--;
					continue;
				}
				copy(1, 0);
			} else if (direct == 2) {
				x--;
				if (x < 0) {
					x++;
					continue;
				}
				copy(1, 1);
			} else if (direct == 3) {
				y--;
				if (y < 0) {
					y++;
					continue;
				}
				copy(0, 0);
			} else if (direct == 4) {
				y++;
				if (y >= n) {
					y--;
					continue;
				}
				copy(0, 1);
			}
			var bottom = dice[3][1];
			var tempTop = dice[1][1];
			if (map[y][x] == 0) {
				map[y][x] = result[bottom];
			} else {
				result[bottom] = map[y][x];
				map[y][x] = 0;
			}
			sb.append(result[tempTop] + "\n");
			//System.out.println(i + " " + Arrays.deepToString(dice) + " " + Arrays.toString(result) + " " + Arrays.deepToString(map));
		}
		System.out.println(sb.toString());
	}

	private static void copy(int i, int d) {
		var queue = new LinkedList<Integer>();
		for (int j = 0; j < 4; j++) {
			var y = direct[i][j][0];
			var x = direct[i][j][1];
			queue.add(dice[y][x]);
		}

		if (d == 0) {
			queue.addLast(queue.pollFirst());
		} else {
			queue.addFirst(queue.pollLast());
		}

		for (int j = 0; j < 4; j++) {
			var y = direct[i][j][0];
			var x = direct[i][j][1];
			dice[y][x] = queue.get(j);
		}
	}
}
/*
2 2 1 0 1
0 0
0 1
1
 */