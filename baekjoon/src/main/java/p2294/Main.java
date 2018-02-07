package p2294;

import java.util.Arrays;
import java.util.Scanner;

// 동전 2
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] l = new int[n + 1];
		int[] dp = new int[m + 1];

		Arrays.fill(dp, 10001);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			l[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			for (int j = l[i]; j <= m; j++) {
				dp[j] = Math.min(dp[j], dp[j - l[i]] + 1);
			}
		}

		System.out.println(Arrays.toString(dp));
		System.out.println(dp[m] == 10001 ? -1 : dp[m]);
	}
}