package p2079;

import java.util.Scanner;

public class Main {

	static String[] m;
	static int[] dp;
	static int n;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		m = sc.next().split("");
		n = m.length;
		dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (palindrome(j - 1, i - 1)) {
					if (dp[i] == 0 || dp[i] > dp[j - 1] + 1) {
						dp[i] = dp[j - 1] + 1;
					}
				}
			}
		}
		System.out.println(dp[n]);
	}

	private static boolean palindrome(int s, int e) {
		while (s < e) {
			if (!m[s++].equals(m[e--])) {
				return false;
			}
		}
		return true;
	}
}
// aba cc bcb
// aaabbbbabab
// anavolimilana