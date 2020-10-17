package p10993;

import java.util.Scanner;

public class Main {

	static String m[][];
	static StringBuilder sb;
	static int n;
	static int h = 1;
	static int w = 1;
	static int hh = 1;
	static int ww = 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sb = new StringBuilder();
		for (int i = 1; i < n; i++) {
			hh = hh * 2;
			h = hh + h;
			ww = ww * 2;
			w = ww + w;
		}
		m = new String[h][w];
		init(m);
		recursive(0, 0, h, w, n);
		display(m);
	}

	private static void init(String[][] m) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				m[i][j] = " ";
			}
		}
	}

	private static void display(String[][] m) {
		var ww = w;
		var wm = w / 2;
		for (int i = 0; i < h; i++) {
			ww = ww - 1;
			wm = wm + 1;
			for (int j = 0; j < w; j++) {
				if ((ww < j && (n % 2) == 0) || (wm <= j && (n % 2) == 1)) {
					sb.append("");
				} else {
					sb.append(m[i][j]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void recursive(int hs, int ws, int h, int w, int k) {
		if (k == 0) return;

		var wm = (ws + ws + w) / 2;

		if (k % 2 == 1) {
			var wws = wm;
			var wwe = wm;
			for (int i = hs; i < hs + h; i++) {
				for (int j = wws; j <= wwe; j++) {
					if (j == wws || j == wwe || i == hs + h - 1 || i == hs) {
						m[i][j] = "*";
					} else {
						m[i][j] = " ";
					}
				}
				wws--;
				wwe++;
			}
		} else {
			var wws = ws;
			var wwe = ws + w;
			for (int i = hs; i < hs + h; i++) {
				for (int j = wws; j < wwe; j++) {
					if (i == hs + h - 1 || i == hs || j == wws || j == wwe - 1) {
						m[i][j] = "*";
					} else {
						m[i][j] = " ";
					}
				}
				wws++;
				wwe--;
			}
		}

		ws = ws + (int) Math.pow(2, k - 1);
		if (k % 2 == 1) {
			recursive(hs + h / 2, ws, h / 2, w - (int) Math.pow(2, k), k - 1);
		} else {
			recursive(hs + 1, ws, h / 2, w - (int) Math.pow(2, k), k - 1);
		}
	}
}
