package p11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// dynamic programming
// 구간 합 구하기 5
public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ins = br.readLine().split(" ");
		int n = Integer.parseInt(ins[0]);
		int t = Integer.parseInt(ins[1]);
		int s = 0;
		int[][] dp = new int[1025][1025];
		int[][] arr = new int[1025][1025];

		for (int i = 1; i <= n; i++) {
			String[] row = br.readLine().split(" ");
			dp[i][0] = s;
			for (int j = 1; j <= n; j++) {
				int c = Integer.parseInt(row[j - 1]);
				arr[i][j] = c;
				dp[i][j] = arr[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
			}
		}

		for (int i = 0; i < t; i++) {
			String[] position = br.readLine().split(" ");
			int x1 = Integer.parseInt(position[0]);
			int y1 = Integer.parseInt(position[1]);
			int x2 = Integer.parseInt(position[2]);
			int y2 = Integer.parseInt(position[3]);
			System.out.println(section(x1, y1, x2, y2, dp));
		}
	}

	private static long section(int x1, int y1, int x2, int y2, int[][] dp) {
		return dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
	}
}