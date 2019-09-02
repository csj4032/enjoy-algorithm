package p1904;

import java.util.Scanner;

/**
 * 제목 : 01타일
 * 링크 : https://www.acmicpc.net/problem/1904
 * 분류 : 다이나믹 프로그래밍, 수학
 */
//11100
//00111
//10000
//00001
//10011
//11001
//00100
//11111
//00000
public class Main {

	static int[] dp = new int[1000001];

	static {
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 5;
		dp[5] = 8;

		for (int i = 6; i < 1000001; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(dp[n]);
	}
}