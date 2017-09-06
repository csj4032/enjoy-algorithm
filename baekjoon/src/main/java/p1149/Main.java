package p1149;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] m = new int[n + 1][3];
		int[][] l = new int[n + 1][3];

		m[0][0] = m[0][1] = m[0][2] = 0;
		l[0][0] = l[0][1] = l[0][2] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 3; j++) {
				m[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= n; i++) {
			l[i][0] = Math.min(l[i - 1][1], l[i - 1][2]) + m[i][0];
			l[i][1] = Math.min(l[i - 1][0], l[i - 1][2]) + m[i][1];
			l[i][2] = Math.min(l[i - 1][0], l[i - 1][1]) + m[i][2];
		}

		System.out.println(Math.min(Math.min(l[n][0], l[n][1]), l[n][2]));
	}
}