package levelThree;

import java.util.Arrays;

public class Change {

	public int solution(int n, int[] money) {
		int[] dp = new int[n + 1];
		int l = money.length;
		dp[0] = 1;
		for (int i = 0; i < l; i++) {
			for (int j = money[i]; j <= n; j++) {
				dp[j] = dp[j] + dp[j - money[i]];
			}
		}

		return dp[n];
	}
}
