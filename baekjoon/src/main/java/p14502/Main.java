package p14502;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	static int[][] l;
	static boolean[][] v;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		l = new int[n][m];
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				l[i][j] = sc.nextInt();
			}
		}

		dsf(0, 0, 0);

	}

	private static void dsf(int d, int h, int w) {
		if (d == 2) {
			//System.out.println("d : " + d + " h :" + h + " w: " + w);
			System.out.println(Arrays.deepToString(l));
			return;
		}

		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				if (l[j][k] == 0 && !v[j][k]) {
					v[j][k] = true;
					l[j][k] = 1;
					dsf(d + 1, j, k);
					l[j][k] = 0;
					v[j][k] = false;
				}
			}
		}
	}
}
