package p1149;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] m = new int[n][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				m[i][j] = sc.nextInt();
			}
		}
		recursive(m, 3, 0, 0, 0, "");
	}

	private static void recursive(int[][] m, int n, int d, int k, int p, String r) {
		if (d == n) {
			System.out.println(p + " " + r);
			return;
		}
		for (int i = 0; i < n; i++) {
			recursive(m, n, d + 1, i, p + m[d][i], r + "" + i);
		}
	}
}