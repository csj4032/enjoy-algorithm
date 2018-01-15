package p11057;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] dp = new long[n + 1][11];

		Arrays.fill(dp[0], 1);

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 10; j++) {
				for (int k = 1; k <= j; k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] = dp[i][j] % 10007;
				}
			}
		}

		for (int i = 0; i <= n; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}

		System.out.println(dp[n][10]);
	}
}