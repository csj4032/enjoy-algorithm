package medium;

import java.util.Arrays;

public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) return false;
		int m = s1.length();
		int n = s2.length();
		boolean [][] dp = new boolean[m+1][n+1];
		dp[0][0] = true;

		for(int i = 1; i <= m; i++) dp[i][0] = dp[i - 1][0] && s1.charAt(i-1) == s3.charAt(i-1);
		for(int i = 1; i <= n; i++) dp[0][i] = dp[0][i - 1] && s2.charAt(i-1) == s3.charAt(i-1);

		System.out.println(Arrays.deepToString(dp));

		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if((dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1))) {
					dp[i][j] = true;
				}
			}
		}

		System.out.println(Arrays.deepToString(dp));
		return dp[m][n];
	}
}
