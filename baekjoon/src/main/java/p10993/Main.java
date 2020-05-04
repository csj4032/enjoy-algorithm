package p10993;

import java.util.Scanner;

public class Main {

	static char m[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = 1;
		int f = 4;
		int h = 1;
		int t = 2;
		for (int i = 0; i < n - 1; i++) {
			w += f;
			f *= 2;
			h += t;
			t *= 2;
		}
		m = new char[w][f];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				m[j][i] = ' ';
			}
		}

		display(0, 0, h, w, n);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				sb.append(m[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void display(int s, int e, int h, int w, int k) {
		if (k <= 0) {
			return;
		}
		int mid = (s + s + w) / 2;
		int l = s;
		int r = s + w;

		if (k % 2 == 1) {
			int ll = mid;
			int rr = mid;
			for (int i = e; i < e + h; i++) {
				for (int j = ll; j <= rr; j++) {
					if (i == e || i == e + h - 1 || j == ll || j == rr) {
						m[i][j] = '*';
					} else {
						m[i][j] = ' ';
					}
				}
				ll--;
				rr++;
			}
		} else {
			int ll = l;
			int rr = r;
			for (int i = e; i < e + h; i++) {
				for (int j = ll; j < rr; j++) {
					if (i == e || i == e + h - 1 || j == ll || j == rr - 1) {
						m[i][j] = '*';
					} else {
						m[i][j] = ' ';
					}
				}
				ll++;
				rr--;
			}
		}

		int mr = s + (int) Math.pow(2, k - 1);
		if (k % 2 == 1) {
			display(mr, e + h / 2, h / 2, w - (int) Math.pow(2, k), k - 1);
		} else {
			display(mr, e + 1, h / 2, w - (int) Math.pow(2, k), k - 1);
		}
	}
}