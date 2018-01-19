package p11401;

import java.util.Scanner;

public class Main {

	private static int mod = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		System.out.println(dynamic(n, k));
	}

	public static long dynamic(int n, int k) {
		int i, j;
		long[][] dp = new long[n + 1][k + 1];
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || i == j) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] % mod;
				}
			}
		}
		return dp[n][k];
	}
}