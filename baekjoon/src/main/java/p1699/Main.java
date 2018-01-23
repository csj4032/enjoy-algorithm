package p1699;

import java.util.Scanner;

public class Main {

	static int dp[] = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			dp[i] = i;
		}

		int k = (int) Math.sqrt(n) + 1;

		for (int i = 2; i < k; i++) {
			for (int j = 1; j <= n; j++) {
				int m = (int) Math.pow(i, 2);
				int l = (j / m) + dp[(j % m)];
				if (dp[j] > l) dp[j] = l;
			}
		}

		System.out.println(dp[n]);
	}
}