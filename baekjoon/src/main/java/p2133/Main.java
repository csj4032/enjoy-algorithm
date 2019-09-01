package p2133;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static long[] dp = new long[31];

	static {
		dp[0] = 0;
		dp[1] = 2;
		dp[2] = 3;
		dp[3] = 6;
		dp[4] = 11;

		for (int i = 3; i < 31; i++) {
			dp[i] = dp[i - 2] * 2 + 2;
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(dp));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(dp[n]);
	}
}
