package levelThree;

public class WayToSchool {

	public long solution(int m, int n, int[][] puddles) {
		int[][] dp = new int[n + 1][m + 1];
		dp[0][1] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				boolean puddle = false;
				for (int k = 0; k < puddles.length; k++) {
					if ((puddles[k][1] == i) && (puddles[k][0] == j)) {
						puddle = true;
						continue;
					}
				}
				if (puddle) continue;
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
			}
		}
		display(dp);
		long answer = dp[n][m];
		return answer;
	}

	private void display(int[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}