package p11401;

import java.util.Scanner;

/**
 * 제목 : 이항 계수 3
 * 링크 : https://www.acmicpc.net/problem/11401
 * 분류 : Binomial Coefficient, Modular
 * 참고 : https://ohgym.tistory.com/13
 * nCk = n!/k!(n-k)!
 * nCk = n-1Ck + n-1Ck-1
 * 5C2 = 4C2 + 4C1
 */
public class Main {

	private static int mod = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(dynamic(n%mod, k%mod));
	}

	public static long dynamic(int n, int k) {
		int i, j;
		int[][] dp = new int[n + 1][k + 1];
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || i == j) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] % mod;
				}
			}
		}
		return dp[n][k];
	}
}