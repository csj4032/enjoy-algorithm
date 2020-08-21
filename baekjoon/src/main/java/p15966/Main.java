package p15966;

import java.util.Scanner;

public class Main {

	private static int[] dp = new int[1000001];
	private static int[] m = new int[100001];

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var k = 0;
		for (int i = 0; i < n; i++) m[i] = sc.nextInt();
		for (int i = 0; i < n; i++) {
			dp[m[i]] = dp[m[i] - 1] + 1;
			k = Math.max(k, dp[m[i]]);
		}
		System.out.println(k);
	}
}