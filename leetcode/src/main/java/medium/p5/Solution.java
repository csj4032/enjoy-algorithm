package medium.p5;

import java.util.Arrays;

public class Solution {

	public String longestPalindrome(String s) {
		int length = s.length();
		boolean dp[][] = new boolean[length][length];
		int begin = 0;
		int max = 0;

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i == j) dp[i][j] = true;
			}
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (s.charAt(i) == s.charAt(j) && (dp[j + 1][i - 1] || i - j <= 2)) {
					dp[j][i] = true;
					if (max < i - j + 1) {
						max = i - j + 1;
						begin = j;
					}
				}
			}
		}
		return s.substring(begin, begin + max);
	}

	private void display(boolean[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
