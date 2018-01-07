package p1912;

import java.util.Scanner;

//http://spillmoon.tistory.com/50
public class Main {

	static int max = 0;
	static int n = 0;
	static int[] m;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = new int[n];
		dp = new int[n];

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		max = dp[0] = m[0];

		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(m[i], dp[i - 1] + m[i]);
			if (max < dp[i]) max = dp[i];
		}

		System.out.println(max);
	}
}