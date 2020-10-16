package p10997;

import java.util.Scanner;

public class Main {

	static int n;
	static int h = 1;
	static int w = 1;
	static String[][] m;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 1; i < n; i++) {
			h = 4 * i + 3;
			w = 4 * i + 1;
		}
		m = new String[h][w];
		init(m);
		recursive(0);
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
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				var star = m[i][j];
				if (i == 1 && star == " ") star = "";
				System.out.print(star);
			}
			System.out.println();
		}
	}

	private static void recursive(int depth) {
		if (depth >= n) return;
		var hs = depth * 2;
		var ws = depth * 2;
		var he = h - depth * 2;
		var we = w - depth * 2;
		for (int i = hs; i < he; i++) {
			for (int j = ws; j < we; j++) {
				if (i == hs || i == he - 1 || j == ws || j == we - 1) {
					m[i][j] = "*";
					if (j == we - 1 && i == hs + 1 && i != h / 2) {
						m[i][j] = " ";
						m[i + 1][j - 1] = "*";
					}
				}
			}
		}
		recursive(depth + 1);
	}
}