package p11048;

import java.util.Scanner;

// 이동하기
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] candy = new int[n][m];
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				candy[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				int max = Math.max(Math.max(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]);
				dp[i][j] = candy[i - 1][j - 1] + max;
			}
		}

		System.out.println(dp[n][m]);
	}
}