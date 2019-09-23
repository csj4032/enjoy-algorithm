package p2565;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = 0;
		int[] dp = new int[501];
		int[] line = new int[501];

		for (int i = 0; i < n; i++) line[sc.nextInt()] = sc.nextInt();

		Arrays.fill(dp, 1);
		for (int i = 1; i < 500; i++) {
			if (line[i] == 0) continue;
			for (int j = 1; j < i; j++) {
				if (line[i] > line[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			m = Math.max(m, dp[i]);
		}
		System.out.println(n - m);
	}
}
