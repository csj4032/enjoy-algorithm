package p1965;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[1001];
		int[] dp = new int[1001];
		Arrays.fill(dp, 1);

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (m[j] < m[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		System.out.println(Arrays.stream(dp).max().orElse(0));
	}
}
