package p9465;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목 : 스티커
 * 링크 : https://www.acmicpc.net/problem/9465
 * 분류 : 다이나믹 프로그래밍
 */

//50 10 100 20 40
//30 50 70 10 60
//0    50   40    200   140    250
//0    30   100   120   210    260
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m[][] = new int[2][n];
			int dp[][] = new int[2][n + 1];

			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < n; k++) {
					m[j][k] = sc.nextInt();
				}
			}

			dp[0][1] = m[0][0];
			dp[1][1] = m[1][0];

			int max = 0;
			for (int j = 2; j < n + 1; j++) {
				for (int k = 0; k < 2; k++) {
					dp[k][j] = Math.max(dp[1 - k][j - 2], dp[1 - k][j - 1]) + m[k][j - 1];
					max = Math.max(max, dp[k][j]);
				}
			}
			sb.append(max + "\n");
		}
		System.out.println(sb.toString());
	}
}