package p11057;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n + 1][10];

		for (int i = 1; i <= n; i++) {
			int m = dp[i].length;
			for (int j = 0; j < m; j++) {
				System.out.println(dp[i][j]);
			}
		}
	}
}