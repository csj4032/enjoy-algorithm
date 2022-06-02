package levelThree;

public class ThreeNTiling {

	public long solution(int n) {
		long mod = 1_000_000_007l;
		long[] dp = new long[n + 1];
		dp[0] = 1;
		dp[2] = 3;
		for (int i = 4; i <= n; i += 2) {
			dp[i] = (dp[i - 2] * 3) % mod;
			long k = 0;
			for (int j = 4; j <= i; j += 2) {
				k = k + ((dp[i - j] * 2) % mod);
			}
			dp[i] = (dp[i] + k) % mod;
		}
		long answer = dp[n];
		return answer;
	}
}
