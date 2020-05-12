package p14889;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int[][] m;
	static boolean[] v;
	static int[] d;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		m = new int[n][n];
		v = new boolean[n];
		d = new int[n];

		for (int i = 0; i < n; i++) {
			m[i][i] = sc.nextInt();
		}

		dfs(0, 0);
	}

	private static void dfs(int s, int l) {
		if (l >= n / 2) {
			System.out.println(Arrays.toString(v));
		} else {
			for (int i = s; i < n; i++) {
				if (!v[i]) {
					v[i] = true;
					d[l] = i + 1;
					dfs(i, l + 1);
				}
			}
		}
		v[s] = false;
	}
}