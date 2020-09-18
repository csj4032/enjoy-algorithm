package p14503;

import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	static int r;
	static int c;
	static int d;
	static int s;
	static int[][] dd = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[][] mm;
	static boolean[][] vv;

	public static void main(String[] args) {
//		var sc = new Scanner(System.in);
//		n = sc.nextInt();
//		m = sc.nextInt();
//		r = sc.nextInt();
//		c = sc.nextInt();
//		d = sc.nextInt();
//		mm = new int[n][m];
//		vv = new boolean[n][m];
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				mm[i][j] = sc.nextInt();
//			}
//		}
//		while (true) {
//			if (mm[r][c] == 0 && !vv[r][c]) {
//				vv[r][c] = true;
//				s++;
//			}
//			var ddd = (d + 3) % 4;
//			var rr = dd[ddd][0] + r;
//			var cc = dd[ddd][1] + c;
//			if (mm[rr][cc] == 0 && !vv[rr][cc]) {
//				r = rr;
//				c = cc;
//				d = ddd;
//			} else {
//				if (isVisitor(r, c)) {
//					var bbbb = (d + 2) % 4;
//					r = r + dd[bbbb][0];
//					c = c + dd[bbbb][1];
//					if (isBackWall(r, c, bbbb)) break;
//				} else {
//					d = ddd;
//				}
//			}
//		}
//		System.out.println(s);

		var aa = new Comparable<>() {
			@Override
			public int compareTo(Object o) {
				return 0;
			}
		};
	}

	private static boolean isBackWall(int r, int c, int d) {
		return mm[r][c] == 1;
	}

	private static boolean isVisitor(int r, int c) {
		var u = false;
		var ll = false;
		var rr = false;
		var d = false;
		if (vv[r - 1][c] || mm[r - 1][c] == 1) u = true;
		if (vv[r][c - 1] || mm[r][c - 1] == 1) ll = true;
		if (vv[r][c + 1] || mm[r][c + 1] == 1) rr = true;
		if (vv[r + 1][c] || mm[r + 1][c] == 1) d = true;
		if (u && ll && rr && d) return true;
		return false;
	}
}
