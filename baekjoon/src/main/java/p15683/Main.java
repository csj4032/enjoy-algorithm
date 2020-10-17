package p15683;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 제목 : 감시
 * 링크 : https://www.acmicpc.net/problem/15683
 * 분류 : 구현, 브루트포스 알고리즘, 시뮬레이션
 */
public class Main {

	static int n;
	static int m;
	static int k;
	static int t = Integer.MAX_VALUE;
	static int[][] map;
	static List<CCTV> cctv = new ArrayList<>();
	static boolean[] visitor = new boolean[8];
	static int[] directs = new int[8];
	static int[] dy = new int[]{0, 0, -1, 1};
	static int[] dx = new int[]{1, -1, 0, 0};

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				var d = sc.nextInt();
				if (0 < d && d < 6) {
					k++;
					cctv.add(new CCTV(i, j, d));
				}
				map[i][j] = d;
			}
		}
		recursive(0);
		System.out.println(t);
	}

	private static void recursive(int depth) {
		if (depth >= k) {
			var temp = copyMap(map);
			for (int i = 0; i < k; i++) {
				var tv = cctv.get(i);
				var ddy = tv.y;
				var ddx = tv.x;
				var kk = 0;
				var tt = 0;
				if (tv.type == 1) {
					surveillance(temp, dy[directs[i]], dx[directs[i]], ddy, ddx);
				} else if (tv.type == 2) {
					surveillance(temp, dy[directs[i]], dx[directs[i]], ddy, ddx);
					if (directs[i] == 0) kk = 1;
					if (directs[i] == 1) kk = 0;
					if (directs[i] == 2) kk = 3;
					if (directs[i] == 3) kk = 2;
					surveillance(temp, dy[kk], dx[kk], ddy, ddx);
				} else if (tv.type == 3) {
					if (directs[i] == 0) kk = 3;
					if (directs[i] == 1) kk = 2;
					if (directs[i] == 2) kk = 0;
					if (directs[i] == 3) kk = 1;
					surveillance(temp, dy[directs[i]], dx[directs[i]], ddy, ddx);
					surveillance(temp, dy[kk], dx[kk], ddy, ddx);
				} else if (tv.type == 4) {
					if (directs[i] == 0) kk = 3; tt = 1;
					if (directs[i] == 1) kk = 2; tt = 0;
					if (directs[i] == 2) kk = 0; tt = 3;
					if (directs[i] == 3) kk = 1; tt = 2;
					surveillance(temp, dy[directs[i]], dx[directs[i]], ddy, ddx);
					surveillance(temp, dy[kk], dx[kk], ddy, ddx);
					surveillance(temp, dy[tt], dx[tt], ddy, ddx);
				} else if (tv.type == 5) {
					surveillance(temp, dy[directs[i]], dx[directs[i]], ddy, ddx);
					surveillance(temp, dy[(directs[i] + 1) % 4], dx[(directs[i] + 1) % 4], ddy, ddx);
					surveillance(temp, dy[(directs[i] + 2) % 4], dx[(directs[i] + 2) % 4], ddy, ddx);
					surveillance(temp, dy[(directs[i] + 3) % 4], dx[(directs[i] + 3) % 4], ddy, ddx);
				}
			}
			count(temp);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (!visitor[depth]) {
				visitor[depth] = true;
				directs[depth] = i;
				recursive(depth + 1);
				visitor[depth] = false;
			}
		}
	}

	private static void surveillance(int[][] map, int iy, int ix, int ddy, int ddx) {
		while ((ddy + iy) >= 0 && (ddy + iy) < n && (ddx + ix) >= 0 && (ddx + ix) < m) {
			ddy = ddy + iy;
			ddx = ddx + ix;
			if (map[ddy][ddx] == 6) break;
			if (map[ddy][ddx] != 0) continue;
			map[ddy][ddx] = 7;
		}
	}

	private static void count(int[][] temp) {
		var tt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0) tt++;
			}
		}
		t = Math.min(tt, t);
	}

	private static void display(int[][] temp) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int[][] copyMap(int[][] map) {
		var temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}
}

class CCTV {
	int y;
	int x;
	int type;

	public CCTV(int y, int x, int type) {
		this.y = y;
		this.x = x;
		this.type = type;
	}

	@Override
	public String toString() {
		return "CCTV{" +
				"y=" + y +
				", x=" + x +
				", type=" + type +
				'}';
	}
}
/*
4 5
0 0 2 0 3
0 6 0 0 0
0 0 6 6 0
0 0 0 0 0

5 5
0 0 0 0 0
0 0 0 0 0
0 0 2 0 0
0 0 0 0 0
0 0 0 0 0
 */