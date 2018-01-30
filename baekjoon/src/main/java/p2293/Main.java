package p2293;

import java.util.Scanner;

// 동전 1
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] l = new int[n + 1];
		int[] dp = new int[m + 1];
		dp[0] = 1;

		for (int i = 0; i < n; i++) {
			l[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			for (int j = l[i]; j <= m; j++) {
				dp[j] += dp[j - l[i]];
			}
		}

		//System.out.println(Arrays.toString(dp));
		System.out.println(dp[m]);
	}
}
