package p2294;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] c = new int[n];
		int[] dp = new int[m + 1];

		for (int i = 0; i < n; i++) {
			c[i] = sc.nextInt();
		}

		Arrays.fill(dp, -1);
		dp[0] = 0;
		//dp[1] = 1;

//		for (int i = 0; i < n; i++) {
//			for (int j = c[i]; j <= m; j++) {
//				if (dp[j] > dp[j - c[i]] || dp[j] == 0) {
//					dp[j] = dp[j - c[i]] + 1;
//				}
//			}
//		}
		for (int i = 0; i < n; i++) {
			for (int j = c[i]; j <= m; j++) {
				if (dp[j] > dp[j - c[i]] || dp[j - c[i]] >= 0) {
					dp[j] = dp[j - c[i]] + 1;
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[m]);


	}
}
