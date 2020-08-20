package p10941;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var s = sc.next();
		var k = decode(s);
		System.out.println(k);
	}

	private static String decode(String enc) {
		int l = enc.length();
		StringBuffer dec = new StringBuffer(l / 2);
		for (int i = 0; i < l; i += 2) {
			byte n, b;
			b = (byte) (enc.charAt(i));
			if ((b >= (byte) ('0')) && (b <= (byte) ('9'))) {
				n = (byte) (b - (byte) ('0'));
			} else {
				n = (byte) (b - (byte) ('A') + 10);
			}

			b = (byte) (enc.charAt(i + 1));
			if ((b >= (byte) ('0')) && (b <= (byte) ('9'))) {
				n = (byte) ((n << 4) + b - (byte) ('0'));
			} else {
				n = (byte) ((n << 4) + b - (byte) ('A') + 10);
			}

			dec.append((char) n);
		}
		return dec.toString();
	}
}
