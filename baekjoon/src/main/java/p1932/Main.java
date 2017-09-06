package p1932;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] m = new int[n + 1][n + 1];
		int[][] l = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			m[0][i] = 0;
			l[0][i] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				m[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				l[i][j] = Math.max(l[i - 1][j - 1], l[i - 1][j]) + m[i][j];
			}
		}

		System.out.println(Arrays.stream(l[n]).max().getAsInt());
	}
}