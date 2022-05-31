package levelTwo;

public class LongJump {

	public long solution(int n) {
		int[] dp = new int[2001];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 5;
		for (int i = 5; i < 2001; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
		}
		long answer = dp[n] % 1234567;
		return answer;
	}
}
