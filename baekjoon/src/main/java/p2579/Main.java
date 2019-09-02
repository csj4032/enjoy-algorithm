package p2579;

import java.util.Scanner;

/**
 * 제목 : 계단 오르기
 * 링크 : https://www.acmicpc.net/problem/2579
 * 분류 : 다이나믹 프로그래밍
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n];
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		dp[0] = m[0];
		dp[1] = m[0] + m[1];
		dp[2] = Math.max(m[0], m[1]) + m[2];

		for (int i = 3; i < n; i++) {
			dp[i] = Math.max(m[i - 1] + dp[i - 3] , dp[i - 2]) + m[i];
		}
		System.out.println(dp[n-1]);
	}
}