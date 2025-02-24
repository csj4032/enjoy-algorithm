package levelThree;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12907">거스름돈</a>
 * Category : Dynamic Programming, 동적계획법
 */
public class Change {

	public int solution(int n, int[] money) {
		int[] dp = new int[n + 1];
		int l = money.length;
		dp[0] = 1;

        for (int k : money) {
            for (int j = k; j <= n; j++) {
                dp[j] = dp[j] + dp[j - k];
            }
        }

		return dp[n];
	}
}