package levelThree;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12902">3 x n 타일링</a>
 * Category : Dynamic Programming, 다이나믹 프로그래밍
 */
public class ThreeNTiling {

	public long solution(int n) {
		long mod = 1_000_000_007L;
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
        return dp[n];
	}
}
