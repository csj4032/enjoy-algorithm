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
	static boolean[][] v;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		l = new char[n][m];
		v = new boolean[n][m];
		var r = new Point(0, 0, 0, 0);
		var b = new Point(0, 0, 0, 0);
		var g = new Point(0, 0, 0, 0);

		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < line.length(); j++) {
				char c = line.charAt(j);
				l[i][j] = c;
				if (c == 'R') r = new Point(i, j, 0, 0);
				if (c == 'B') b = new Point(i, j, 0, 0);
				if (c == 'O') g = new Point(i, j, 0, 0);
			}
		}
		//System.out.println("R : " + r);
		//System.out.println("B : " + b);
		//System.out.println("G : " + g);
		//System.out.println(Arrays.deepToString(l));
		bfs(r, b);
	}

	private static void bfs(Point r, Point b) {
		Queue<Point> qr = new LinkedList();
		Queue<Point> qb = new LinkedList();
		qr.offer(r);
		qb.offer(b);
		while (!qr.isEmpty()) {
			var p = qr.poll();
			v[p.y][p.x] = true;
			for (int i = 0; i < 4; i++) {
				var y = p.y + d[i][0];
				var x = p.x + d[i][1];
				var pr = new Point(y, x, i, p.r);
				var pc = new Point(y, x, i, p.r);
				if (l[y][x] == '.' && !v[y][x]) {
					pr.r = p.d != i ? p.r + 1 : p.r;
					qr.offer(pr);
					if(1==1) {
						qb.offer(null);
					}
				} else if (l[y][x] == 'O') {
					System.out.println(pr);
				}
			}
		}
	}

	public static class Point {
		int y;
		int x;
		int d;
		int r;

		public Point(int y, int x, int d, int r) {
			this.y = y;
			this.x = x;
			this.d = d;
			this.r = r;
		}

		@Override
		public String toString() {
			return "Point{" +
					"y=" + y +
					", x=" + x +
					", d=" + d +
					", r=" + r +
					'}';
		}
	}
}
