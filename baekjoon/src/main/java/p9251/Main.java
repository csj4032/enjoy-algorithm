package p9251;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://ko.wikipedia.org/wiki/최장_공통_부분_수열
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		System.out.println(longestCommonSubsequence(a, b));
	}

	private static int longestCommonSubsequence(String str1, String str2) {
		String[] arr1 = str1.split("");
		String[] arr2 = str2.split("");

		int n = arr1.length;
		int m = arr2.length;

		int dp[][] = new int[n + 1][m + 1];
		Arrays.fill(dp[0], 0);

		for (int i = 0; i < n; i++) {
			dp[i][0] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (arr1[i-1].equals(arr2[j-1])) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp[n][m];
	}
}