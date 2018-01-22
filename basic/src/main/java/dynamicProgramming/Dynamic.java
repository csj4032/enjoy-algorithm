package dynamicProgramming;

import java.util.Arrays;

public class Dynamic {

	public static void main(String[] args) {
		int[] n = new int[]{10, -4, 3, 1, 5, 6, -35, 12, 21, -1};
		int[] dp = new int[n.length];

		dp[0] = n[0];

		for (int i = 1; i < n.length; i++) {
			if (dp[i - 1] + n[i] > n[i]) {
				dp[i] = dp[i - 1] + n[i];
			} else {
				dp[i] = n[i];
			}
		}

		System.out.println(Arrays.stream(dp).max().orElse(0));
	}
}