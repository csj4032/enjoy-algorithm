package p1520;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목 : 내리막 길
 * 링크 : https://www.acmicpc.net/problem/1520
 * 분류 : 다이나믹 프로그래밍
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] br = new int[n + 1][m + 1];
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				br[i][j] = sc.nextInt();
			}
		}

		dp[1][1] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (br[i][j] < br[i - 1][j] && br[i][j] < br[i][j - 1]) {
					dp[i][j] = dp[i - 1][j] - dp[i][j] + dp[i][j - 1] - dp[i][j];
				} else if (br[i][j] < br[i - 1][j] && br[i][j] >= br[i][j - 1]) {
					dp[i][j] += dp[i - 1][j] - dp[i][j];
				} else if (br[i][j] >= br[i - 1][j] && br[i][j] < br[i][j - 1]) {
					dp[i][j] += dp[i][j - 1] - dp[i][j];
				}
			}
		}
		System.out.println();
		System.out.println(Arrays.deepToString(dp));
	}
}