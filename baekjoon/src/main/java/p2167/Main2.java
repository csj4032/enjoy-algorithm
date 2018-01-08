package p2167;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int k = sc.nextInt();
		int[][] index = new int[k][4];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < 4; j++) {
				index[i][j] = sc.nextInt();
			}
		}

		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = dp[i][j - 1] + arr[i][j];
			}
		}

		System.out.println(Arrays.deepToString(arr));
		System.out.println(Arrays.deepToString(dp));

		sc.close();
	}
}