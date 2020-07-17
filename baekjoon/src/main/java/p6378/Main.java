package p6378;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var sb = new StringBuilder();
		while (true) {
			var n = new BigDecimal(sc.next());
			if (n.compareTo(BigDecimal.ZERO) == 0) break;
			var k = new BigDecimal(n.toString());
			while (k.compareTo(BigDecimal.TEN) >= 0) {
				k = digital(k);
			}
			sb.append(k + "\n");
		}
		System.out.println(sb.toString());
	}

	private static BigDecimal digital(BigDecimal n) {
		var k = BigDecimal.ZERO;
		while (true) {
			var m = n.remainder(BigDecimal.TEN);
			n = n.divideToIntegralValue(BigDecimal.TEN);
			k = k.add(m);
			if (n.compareTo(BigDecimal.ZERO) == 0) break;
		}
		return k;
	}
}
