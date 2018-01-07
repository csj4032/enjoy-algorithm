package p9084;

import java.util.Scanner;

// 2293 문제와 유사
// 다이나믹 프로그래밍
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m[] = new int[n];

			for (int j = 0; j < n; j++) {
				m[j] = sc.nextInt();
			}

			int p = sc.nextInt();
			int[] dp = new int[p + 1];
			dp[0] = 1;

			for (int j = 0; j < n; j++) {
				for (int k = m[j]; k < p + 1; k++) {
					dp[k] += dp[k - m[j]];
				}
			}
			System.out.println(dp[p]);
		}
	}
}