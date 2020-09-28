package p12865;

import java.util.*;

/**
 * 제목 : 평범한 배낭
 * 링크 : https://www.acmicpc.net/problem/12865
 * 분류 : 다이나믹 프로그래밍, 배낭 문제
 */
public class Main {

	static int m[];
	static int w[];
	static int v[];
	static long dp[][];

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var k = sc.nextInt();
		m = new int[n];
		w = new int[n];
		v = new int[n];
		dp = new long[n + 1][k + 1];

		for (int i = 0; i < n; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (w[i - 1] <= j) {
					dp[i][j] = Math.max(v[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n][k]);
		System.out.println(Arrays.deepToString(dp));
	}

	private static void display(long[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
/*
5 7
6 13
4 8
2 10
3 6
5 12

4 7
1 1000
2 1000
3 1000
5 1000

4 7
3 6
4 8
5 12
6 13

4 7
3 6
5 18
4 8
5 12

8 4
1 3
1 6
1 3
1 3
1 3
1 2
1 5
1 8

 */