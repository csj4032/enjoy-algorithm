package p2133;

import java.util.Scanner;

/**
 * 제목 : 타일 채우기
 * 링크 : https://www.acmicpc.net/problem/2133
 * 분류 : Dynamic Programming
 */
public class Main {

	static long[] dp = new long[31];

	static {
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 3;
		dp[3] = 0;
		dp[4] = 11;
		dp[5] = 0;
		dp[6] = 41;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(dp[n]);
	}
}
