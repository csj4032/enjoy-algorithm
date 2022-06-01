package levelThree;

public class ExpressedAsN {

	public int solution(int N, int number) {
		int[] dp = new int[32001];
		dp[0] = 2;
		dp[1] = 2;
		for (int i = 1; i <= number; i++) {
			if (i % N == 0) {
				dp[i] = i / N;
			} else {
				dp[i] = dp[i - 1] + 1 + (i / 10);
			}
		}
		int answer = dp[number];
		return answer;
	}
}
