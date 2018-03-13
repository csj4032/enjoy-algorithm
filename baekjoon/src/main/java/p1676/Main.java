package p1676;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		BigDecimal t = new BigDecimal(BigInteger.ONE);

		for (int i = 1; i <= n; i++) {
			t = t.multiply(new BigDecimal(i));
		}

		StringBuilder sb = new StringBuilder(t.toString());
		String reverse = sb.reverse().toString();

		int zeroIndex = 0;
		int zeroCount = 0;
		while (true) {
			if (reverse.charAt(zeroIndex) == '0') {
				zeroIndex++;
				zeroCount++;
			} else {
				break;
			}
		}
		System.out.println(zeroCount);
	}
}