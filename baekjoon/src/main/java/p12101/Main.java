package p12101;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var k = sc.nextInt();
		var dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
		}

		System.out.println(Arrays.toString(dp));
	}
}


//<1> 2 3 <4> <8> 9
//<1> 2 3 <4> 5 6 7 8 <9>