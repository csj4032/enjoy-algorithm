package p11049;

import java.util.Scanner;

public class Main {

	static int dp[][] = new int[501][501];
	static int m[][] = new int[501][2];

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			m[i][0] = sc.nextInt();
			m[i][1] = sc.nextInt();
		}

		for (int i = 1; i <= n - 1; i++) {
			dp[i][i + 1] = m[i][0] * m[i][1] * m[i + 1][1];
		}

		for (int l = 2; l <= n; l++) {
			for (int i = 1; i <= n - 1; i++) {
				int j = i + l;
				for (int k = i; k < j; k++) {
					System.out.println("l : " + l + " i : " + i + " k : " + k + " j : " + j);
					int t = dp[i][k] + dp[k + 1][j] + m[i][0] * m[k][1] * m[j][1];
					if (dp[i][j] == 0 || dp[i][j] > t) {
						dp[i][j] = t;
					}
				}
			}
		}
		System.out.println(dp[1][n]);
	}
}