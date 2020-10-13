package p2239;

import java.util.Scanner;

import static java.lang.System.exit;

/**
 * 제목 : 스도쿠
 * 링크 : https://www.acmicpc.net/problem/2239
 * 분류 : 백트래킹
 */
public class Main {

	static int len = 9;
	static int[][] map = new int[len][len];

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		for (int i = 0; i < len; i++) {
			var line = sc.nextLine();
			for (int j = 0; j < len; j++) {
				map[i][j] = Integer.parseInt(line.split("")[j]);
			}
		}
		backTracking(0);
	}

	private static void backTracking(int cnt) {
		if (cnt == 81) {
			display(map);
			exit(0);
			return;
		}

		var row = cnt / len;
		var col = cnt % len;
		if (map[row][col] == 0) {
			for (int i = 1; i <= len; i++) {
				if (promise(row, col, i)) {
					var t = map[row][col];
					map[row][col] = i;
					backTracking(cnt + 1);
					map[row][col] = t;
				}
			}
		} else {
			backTracking(cnt + 1);
		}
	}

	private static boolean promise(int row, int col, int k) {
		var r = 0;
		for (int i = 0; i < len; i++) {
			if (k == map[i][col]) {
				r++;
			}
		}

		var c = 0;
		for (int i = 0; i < len; i++) {
			if (k == map[row][i]) {
				c++;
			}
		}

		var rc = 0;
		var sr = (row / 3) * 3;
		var sc = (col / 3) * 3;

		for (int i = sr; i < sr + 3; i++) {
			for (int j = sc; j < sc + 3; j++) {
				if (k == map[i][j]) {
					rc++;
				}
			}
		}

		if (r < 1 && c < 1 && rc < 1) {
			return true;
		}

		return false;
	}

	private static void display(int[][] map) {
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
/*
103000509
002109400
000704000
300502006
060000050
700803004
000401000
009205800
804000107

000000000
000000000
000000000
000000000
000000000
000000000
000000000
000000000
000000000
 */