package p4963;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			if (w == 0 && h == 0) break;

			int k = 0;
			int s[][] = new int[h][w];
			boolean v[][] = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					int l = sc.nextInt();
					s[i][j] = l;
					if (l == 0) v[i][j] = true;
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (s[i][j] == 1 && v[i][j] == false) {
						k++;
						dsf(i, j, h, w, v);
					}
				}
			}
			System.out.println(k);
		}
	}

	private static void dsf(int i, int j, int h, int w, boolean[][] v) {
		if (v[i][j] == true) return;
		v[i][j] = true;
		//T, TL, L, BL, B, BR, R, TR
		if (0 < i) dsf(i - 1, j, h, w, v);
		if (0 < i && 0 < j) dsf(i - 1, j - 1, h, w, v);
		if (0 < j) dsf(i, j - 1, h, w, v);
		if (h - 1 > i && 0 < j) dsf(i + 1, j - 1, h, w, v);
		if (h - 1 > i) dsf(i + 1, j, h, w, v);
		if (h - 1 > i && w - 1 > j) dsf(i + 1, j + 1, h, w, v);
		if (w - 1 > j) dsf(i, j + 1, h, w, v);
		if (0 < i && w - 1 > j) dsf(i - 1, j + 1, h, w, v);
	}
}