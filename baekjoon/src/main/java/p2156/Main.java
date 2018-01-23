package p2156;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int dp[] = new int[10001];
	static int n;
	static int m[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = new int[n];

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		dp[0] = 0;
		dp[1] = m[0];
		dp[2] = m[0] + m[1];

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 3] + m[i - 2] + m[i - 1], dp[i - 2] + m[i - 1]);
			System.out.println(Arrays.toString(dp));
		}
		System.out.println(Arrays.stream(dp).max().orElse(0));
	}
}