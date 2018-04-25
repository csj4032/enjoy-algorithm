package p1520;

import java.util.Arrays;
import java.util.Scanner;

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

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(br[i][j] + " ");
				if (br[i][j] < br[i - 1][j]) {
					System.out.print("위");
					dp[i][j] = dp[i - 1][j] + 1;
				}
				if (br[i][j] < br[i][j - 1]) {
					System.out.print("좌");
					dp[i][j] = dp[i][j - 1] + 1;
				}
				if (j < m && br[i][j] < br[i][j + 1]) {
					System.out.print("우");
					dp[i][j] = br[i][j + 1] + 1;
				}
				System.out.println();
			}
		}
		System.out.println();
		System.out.println(Arrays.deepToString(dp));
	}
}