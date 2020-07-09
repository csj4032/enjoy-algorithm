package p14502;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	static int max;
	static int wc = 3;
	static int[][] l;
	static int[][] r = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static boolean[][] v;
	static Queue<Point> queue = new LinkedList();

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		l = new int[n][m];
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				var k = sc.nextInt();
				l[i][j] = k;
				if (k == 2) queue.offer(new Point(i, j));
			}
		}
		dsf(0);
		System.out.println(max);
	}

	private static void dsf(int d) {
		if (d == wc) {
			max = Math.max(max, getMax());
			return;
		}

		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				if (l[j][k] == 0 && !v[j][k]) {
					v[j][k] = true;
					l[j][k] = 1;
					dsf(d + 1);
					l[j][k] = 0;
					v[j][k] = false;
				}
			}
		}
	}

	private static int getMax() {
		var q = new LinkedList<>(queue);
		var ll = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ll[i][j] = l[i][j];
			}
		}
		while (!q.isEmpty()) {
			var t = q.poll();
			for (int i = 0; i < 4; i++) {
				var y = t.y + r[i][0];
				var x = t.x + r[i][1];
				if (0 <= y && y < n && 0 <= x && x < m) {
					if (ll[y][x] == 0) {
						q.offer(new Point(y, x));
						ll[y][x] = 2;
					}
				}
			}
		}
		var k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (ll[i][j] == 0) k++;
			}
		}
		return k;
	}
}

class Point {
	Integer y;
	Integer x;

	Point(Integer y, Integer x) {
		this.y = y;
		this.x = x;
	}

	@Override
	public String toString() {
		return "Point{" + "y=" + y + ", x=" + x + '}';
	}
}
