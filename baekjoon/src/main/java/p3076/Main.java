package p3076;

import java.util.Scanner;

// Coins
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] m = new int[n];

			for (int j = 0; j < n; j++) {
				m[j] = sc.nextInt();
			}

			int k = sc.nextInt();
			int[] dp = new int[k + 1];

			dp[0] = 1;

			for (int j = 0; j < n; j++) {
				for (int q = m[j]; q <= k; q++) {
					dp[q] += dp[q - m[j]];
				}
			}

			System.out.println(dp[k]);
		}
	}
}