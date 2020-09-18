package p17406;

import java.util.Scanner;

public class Main {

	static int[][] l;
	static Tuple[][] p;
	static int[] s;
	static boolean[] v;
	static int n;
	static int m;
	static int k;
	static int q = Integer.MAX_VALUE;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		p = new Tuple[k][2];
		l = new int[n][m];
		s = new int[k];
		v = new boolean[k];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				l[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < k; i++) {
			var r = sc.nextInt();
			var c = sc.nextInt();
			var s = sc.nextInt();
			var ry = r - s - 1;
			var rx = c - s - 1;
			var cy = r + s;
			var cx = c + s;
			p[i] = new Tuple[]{new Tuple(ry, rx), new Tuple(cy, cx)};
		}

		recursive(0);
		System.out.println(q);
	}

	private static void recursive(int d) {
		if (d == k) {
			var rrr = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					rrr[i][j] = l[i][j];
				}
			}
			for (int i = 0; i < s.length; i++) {
				var t = p[s[i]];
				rotation(t, rrr);
			}

			//display(rrr);

			for (int j = 0; j < n; j++) {
				var kkk = 0;
				for (int o = 0; o < m; o++) {
					kkk += rrr[j][o];
				}
				q = Math.min(kkk, q);
			}
			return;
		}
		for (int i = 0; i < k; i++) {
			if (!v[i]) {
				v[i] = true;
				s[d] = i;
				recursive(d + 1);
				v[i] = false;
			}
		}
	}

	private static void display(int[][] rrr) {
		for (int ii = 0; ii < rrr.length; ii++) {
			for (int jj = 0; jj < rrr[0].length; jj++) {
				System.out.print(rrr[ii][jj] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void rotation(Tuple[] t, int[][] rrr) {
		var rr = t[0];
		var cc = t[1];
		//System.out.println(rr + " " + cc);
		var tt = new int[cc.y - rr.y][cc.x - rr.x];
		var ttt = new int[cc.y - rr.y][cc.x - rr.x];
		for (int i = rr.y; i < cc.y; i++) {
			for (int j = rr.x; j < cc.x; j++) {
				tt[i - rr.y][j - rr.x] = rrr[i][j];
			}
		}
		//System.out.println(Arrays.deepToString(tt));
		var nn = tt.length;
		var nnn = tt[0].length;
		var d = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		var dd = 0;
		var dy = 0;
		var dx = 0;
		var ln = nn;
		var sn = 0;
		var lm = nnn;
		var sm = 0;
		//display(tt);
		for (int i = 0; i < nn; i++) {
			for (int j = 0; j < nnn; j++) {
				if (dy + d[dd][0] < sn || dy + d[dd][0] >= ln || dx + d[dd][1] < sm || dx + d[dd][1] >= lm) {
					dd++;
					if (dd == 4) {
						dd = 0;
						dy = dy + 1;
						dx = dx + 1;
						ln = ln - 1;
						lm = lm - 1;
						sn = sn + 1;
						sm = sm + 1;
					}
				}
				if (j == nnn - 1 && i == nn - 1) {
					ttt[dy][dx] = tt[dy][dx];
				} else {
					ttt[dy + d[dd][0]][dx + d[dd][1]] = tt[dy][dx];
				}
				dy += d[dd][0];
				dx += d[dd][1];
			}
		}

		//display(ttt);
		//display(ttt);

		for (int i = 0; i < nn; i++) {
			for (int j = 0; j < nnn; j++) {
				rrr[rr.y + i][rr.x + j] = ttt[i][j];
			}
		}
		//display(rrr);
	}
}

class Tuple {
	int y;
	int x;

	public Tuple(int y, int x) {
		this.y = y;
		this.x = x;
	}

	@Override
	public String toString() {
		return "Tuple{" +
				"y=" + y +
				", x=" + x +
				'}';
	}
}
