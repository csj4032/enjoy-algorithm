package levelTwo;

public class LargestSquareDynamic {

	public int area(int[][] board) {
		int rows = board.length;
		int cols = board[0].length;
		int[][] dp = new int[rows + 1][cols + 1];
		int max = 0;
		for (int i = 1; i < rows + 1; i++) {
			for (int j = 1; j < cols + 1; j++) {
				if (board[i - 1][j - 1] == 1) {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					max = Math.max(dp[i][j], max);
				}
			}
		}
		return max * max;
	}
}
