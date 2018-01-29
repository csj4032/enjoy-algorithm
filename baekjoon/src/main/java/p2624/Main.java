package p2624;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] c = new int[n];
		int[] d = new int[n];
		int[] dp = new int[m + 1];

		for (int i = 0; i < n; i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}

		dp[0] = 1;

		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(d));

		for (int i = 0; i < n; i++) {
			for (int j = c[i]; j <= m; j++) {
				if (0 < d[i]) {
					dp[j] += dp[j - c[i]];
					if (j % c[i] == 0) {
						d[i] = d[i] - 1;
					}
				} else {
					dp[j] = dp[j] + 1;
				}
			}
		}

		System.out.println(Arrays.toString(dp));
	}
}
