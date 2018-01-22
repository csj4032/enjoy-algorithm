package p11051;

import java.util.Scanner;

public class Main {

	private static int mod = 10007;
	private static long[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		dp = new long[n + 1][k + 1];
		System.out.println(dynamic(n, k));
	}

	public static long dynamic(int n, int k) {
		int i, j;
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || i == j) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
				}
			}
		}
		return dp[n][k];
	}
}