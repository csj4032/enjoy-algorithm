package p9252;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] a = sc.next().split("");
		String[] b = sc.next().split("");
		longestCommonSubsequence(a, b);
	}

	private static void longestCommonSubsequence(String[] str1, String[] str2) {
		int n = str1.length;
		int m = str2.length;

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 0; i < n; i++) dp[i][0] = 0;
		for (int i = 0; i < m; i++) dp[0][i] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (str1[i - 1].equals(str2[j - 1])) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		int count = dp[n][m];
		System.out.println(count);
	}
}