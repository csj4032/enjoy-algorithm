package p2225;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] dp = new int[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (i == 1) {
					dp[i][j] = j;
				} else if (j == 1) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
				}
			}
		}

		System.out.println(dp[n][k]);

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}