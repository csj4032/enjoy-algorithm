package p14444;

import java.util.Scanner;

public class Main {

	static boolean[][] dp;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var s = sc.next();
		var l = s.length();
		var n = s.toCharArray();
		dp = new boolean[l][l];
		for (int i = 0; i < l; i++) dp[i][i] = true;

		var t = 1;
		for (int k = 2; k <= l; k++) {
			for (int i = 0; i < l - k + 1; i++) {
				var j = i + k - 1;
				if (n[i] == n[j] && k == 2) {
					dp[i][j] = true;
					t = 2;
				} else if (n[i] == n[j] && dp[i + 1][j - 1]) {
					dp[i][j] = true;
					t = Math.max(k, t);
				}
			}
		}
		System.out.println(t);
	}
}
