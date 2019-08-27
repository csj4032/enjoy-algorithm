package p10844;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] dp = new long[101][11];
		Arrays.fill(dp[1], 1);
		dp[1][10] = 0;
		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][1];
			for (int j = 1; j < 10; j++) {
				long a = dp[i - 1][j - 1];
				long b = dp[i - 1][j + 1];
				dp[i][j] = (a + b) % 1000000000;
			}
		}
		long sum = 0;
		for (int i = 1; i < 10; i++) {
			sum += (dp[n][i]);
		}
		System.out.println(sum % 1000000000);
	}
}
//		0	1	2	3	4	5	6	7	8	9	10
//1		1	1	1	1	1	1	1	1	1	1	0	9
//2		1	2	2	2	2	2	2	2	2	1	0	17
//3		2	3	4	4	4	4	4	4	3	2	0	32
//4		3	6	7	8	8	8	8	7	6	3	0	61
//5		6	10	14	15	16	16	15	14	10	6	0	116
//6		10	20	25	30	31	31	30	25	20	10	0	222