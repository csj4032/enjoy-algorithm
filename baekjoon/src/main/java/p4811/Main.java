package p4811;

import java.util.Scanner;

/**
 * 제목 : 알약
 * 링크 : https://www.acmicpc.net/problem/4811
 * 분류 : 재귀 호출
 */
public class Main {

	static long[][] dp = new long[31][31];

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var sb = new StringBuilder();
		while (true) {
			var n = sc.nextInt();
			if (n == 0) break;
			recursive(n, 0);
			sb.append(dp[n][0] + "\n");
		}
		System.out.println(sb.toString());
	}

	private static long recursive(int w, int h) {
		if (dp[w][h] > 0) return dp[w][h];
		if (w == 0) return 1;
		dp[w][h] = recursive(w - 1, h + 1);
		if (h > 0) dp[w][h] += recursive(w, h - 1);
		return dp[w][h];
	}
}
