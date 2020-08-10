package p11576;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var a = BigInteger.valueOf(sc.nextInt());
		var b = BigInteger.valueOf(sc.nextInt());
		var m = sc.nextInt();
		var t = BigInteger.ZERO;

		while (m > 0) {
			var c = BigInteger.valueOf(sc.nextInt());
			var d = c.multiply(a.pow(m - 1));
			t = t.add(d);
			m--;
		}
		String sb = "";
		while (true) {
			sb = t.mod(b) + " " + sb;
			t = t.divide(b);
			if (t.compareTo(b) < 0) {
				sb = t + " " + sb;
				break;
			}
		}
		System.out.println(sb);
	}
}
