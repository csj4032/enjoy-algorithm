package levelThree;

import java.math.BigInteger;

public class NTiling {

		static BigInteger[] dp = new BigInteger[60000];

		static {
			dp[0] = BigInteger.ONE;
			dp[1] = BigInteger.ONE;
			dp[2] = new BigInteger("2");
			dp[3] = new BigInteger("3");
			dp[4] = new BigInteger("5");

			for (int i = 3; i < 60000; i++) {
				dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.ONE)).divideAndRemainder(BigInteger.valueOf(1000000007))[1];
			}
		}

		public int solution(int n) {
			return dp[n].intValue();
		}
}
