package practice;

import java.util.Arrays;

public class BracketCount {

	int[][] dp = new int[15][15];
	int answer = 0;

	public int solution(int n) {
		answer = recursive(n, 0);
		//parenthesis(0, 0, n);
		System.out.println(Arrays.deepToString(dp));
		return answer;
	}

	private int recursive(int n, int m) {
		if (n < 0) return 0;
		if (n == 0 && m == 0) return 1;
		if (dp[n][m] > 0) return dp[n][m];
		if (n > 0) dp[n][m] += recursive(n - 1, m + 1);
		if (m > 0) dp[n][m] += recursive(n, m - 1);
		return dp[n][m];
	}

	public void parenthesis(int left, int right, int n) {
		if (left < n) {
			parenthesis(left + 1, right, n);
		}
		if (left > right) {
			if ((left == (right + 1) && (right + 1) == n)) {
				answer += 1;
			} else {
				parenthesis(left, right + 1, n);
			}
		}
	}
}
