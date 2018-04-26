package p1010;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목 : 다리 놓기
 * 분류 : 다이나믹 프로그래밍
 * 강 서쪽이(N)강 동쪽(M) 보다 작은 경우는 0
 *
 * N 1 : M 1 >> 1경우
 * N 1 : M 2 >> 2경우
 * N 2 : M 2 >> 1경우
 * N 2 : M 3 >> 3경우 (N 1 M 2) + (N 2, M 2) 합
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int dp[][] = new int[n + 1][m + 1];

			Arrays.fill(dp[0], 1);

			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= m; k++) {
					if (k >= j) {
						dp[j][k] = dp[j - 1][k - 1] + dp[j][k - 1];
					}
				}
			}
			System.out.println(dp[n][m]);
		}
	}
}