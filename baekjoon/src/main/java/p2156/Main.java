package p2156;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[10001];
		int[] dp = new int[10001];

		for (int i = 1; i <= n; i++) {
			m[i] = sc.nextInt();
		}

		dp[0] = 0;
		dp[1] = m[1];
		dp[2] = dp[1] + m[2];

		for (int i = 3; i <= n; i++) {
			int k = Math.max(dp[i - 2] + m[i], dp[i - 3] + m[i] + m[i - 1]);
			dp[i] = Math.max(k, dp[i - 1]);
		}

		//System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
	}
}
