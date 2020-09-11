package p2079;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static String[] m;
	static int[] dp;
	static int t;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		m = sc.next().split("");
		t = m.length;
		dp = new int[20];
		dp[0] = 1;

		for (int i = 2; i < t; i++) {
			if (palindrome(i - 2, i)) {
				dp[i] = dp[i - 2];
			} else {
				if (palindrome(i - 1, i)) {
					dp[i] = dp[i - 1];
				} else {
					dp[i] = dp[i - 1] + 1;
				}
			}
		}
		System.out.println(Arrays.toString(dp));
	}

	private static boolean palindrome(int s, int e) {
		if (t <= e) return false;
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