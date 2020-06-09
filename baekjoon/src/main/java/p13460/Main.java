package p13460;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int d[][] = {
			{-1, 0},
			{0, 1},
			{1, 0},
			{0, -1}
	};

	static int n;
	static int m;
	static char[][] l;
	static boolean[][][][] v;
	static int k = -1;
	static Point p;
	static int gy;
	static int gx;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		l = new char[n][m];
		v = new boolean[10][10][10][10];
		p = new Point();

		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < line.length(); j++) {
				char c = line.charAt(j);
				l[i][j] = c;
				if (c == 'R') {
					p.ry = i;
					p.rx = j;
				}
				if (c == 'B') {
					p.by = i;
					p.bx = j;
				}
				if (c == 'O') {
					gy = i;
					gx = j;
				}
			}
		}
		bfs(p);
		System.out.println(k);
	}

	private static void bfs(Point r) {
		Queue<Point> q = new LinkedList();
		q.offer(r);
		v[r.ry][r.rx][r.by][r.bx] = true;

		while (!q.isEmpty()) {
			var p = q.poll();
			if (p.d > 10) break;

			if (p.ry == gy && p.rx == gx) {
				k = p.d;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int ry = p.ry;
				int rx = p.rx;
				int by = p.by;
				int bx = p.bx;
				Point rm = move(ry, rx, i);
				Point bm = move(by, bx, i);

				ry = rm.ry;
				rx = rm.rx;
				by = bm.ry;
				bx = bm.rx;

				if (by == gy && bx == gx) {
					continue;
				}

				if (ry == by && rx == bx) {
					switch (i) {
						case 0:
							if (p.ry < p.by) {
								by++;
							} else {
								ry++;
							}
							break;
						case 1:
							if (p.rx < p.bx) {
								rx--;
							} else {
								bx--;
							}
							break;
						case 2:
							if (p.ry < p.by) {
								ry--;
							} else {
								by--;
							}
							break;
						case 3:
							if (p.rx < p.bx) {
								bx++;
							} else {
								rx++;
							}
							break;
					}
				}

				if (!v[ry][rx][by][bx]) {
					Point pr = new Point(ry, rx, by, bx, p.d + 1);
					q.add(pr);
					v[ry][rx][by][bx] = true;
				}
			}
		}
	}

	private static Point move(int y, int x, int r) {
		while (1 == 1) {
			y += d[r][0];
			x += d[r][1];
			if (l[y][x] == '#') {
				y -= d[r][0];
				x -= d[r][1];
				break;
			} else if (l[y][x] == 'O') {
				break;
			}
		}
		return new Point(y, x);
	}

	public static class Point {
		public int ry;
		public int rx;
		public int by;
		public int bx;
		public int d;

		public Point() {
		}

		public Point(int ry, int rx) {
			this.ry = ry;
			this.rx = rx;
		}

		public Point(int ry, int rx, int by, int bx, int d) {
			this.ry = ry;
			this.rx = rx;
			this.by = by;
			this.bx = bx;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Point{" +
					"ry=" + ry +
					", rx=" + rx +
					", by=" + by +
					", bx=" + bx +
					", d=" + d +
					'}';
		}
	}
}
