package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class TheCoinChangeProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] l = new int[m + 1];
		int[] dp = new int[n + 1];

		for (int i = 0; i < m; i++) {
			l[i] = sc.nextInt();
		}

		dp[0] = 1;

		for (int i = 0; i < m; i++) {
			for (int j = l[i]; j <= n; j++) {
				dp[j] += dp[j - l[i]];
			}
		}

		System.out.println(Arrays.toString(dp));
	}
}
