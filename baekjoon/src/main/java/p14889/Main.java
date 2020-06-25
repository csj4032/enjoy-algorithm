package p14889;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n;
	static int[][] m;
	static boolean[] v;
	static int[] d;
	static int k;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		m = new int[n][n];
		v = new boolean[n];
		d = new int[n];
		k = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = sc.nextInt();
			}
		}
		dfs(1, 0);
		System.out.println(k);
	}

	private static void dfs(int s, int l) {
		if (l >= n / 2) {
			calculate();
		} else {
			for (int i = s; i < n; i++) {
				if (!v[i]) {
					v[i] = true;
					dfs(i + 1, l + 1);
					v[i] = false;
				}
			}
		}
	}

	private static void calculate() {
		List<Integer> ss = new ArrayList<>();
		List<Integer> ll = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (v[i]) {
				ss.add(i);
			} else {
				ll.add(i);
			}
		}

		int sss = 0;
		int lll = 0;

		for (int i = 0; i < n / 2; i++) {
			for (int j = i + 1; j < n / 2; j++) {
				sss += m[ss.get(i)][ss.get(j)];
				sss += m[ss.get(j)][ss.get(i)];
			}

			for (int j = i + 1; j < n / 2; j++) {
				lll += m[ll.get(i)][ll.get(j)];
				lll += m[ll.get(j)][ll.get(i)];
			}
		}

		k = Math.min(k, Math.abs(sss - lll));
	}
}