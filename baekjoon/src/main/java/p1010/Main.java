package p1010;

import java.util.Arrays;
import java.util.Scanner;

//조합의 공식은 n! / r!(n-r)!
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			long[][] dp = new long[n + 1][m + 1];

			for (int i = 0; i <= m; i++) {
				dp[1][i] = i;
			}

			for (int i = 2; i <= n; i++) {
				for (int j = i; j <= m; j++) {
					for (int k = i - 1; k < j; k++) {
						System.out.print("i : " + i + " j : " + j + " k : " + k + " | ");
						dp[i][j] += dp[i - 1][k];
					}
					System.out.println("");
				}
			}
			System.out.println(Arrays.deepToString(dp));
		}
	}
}