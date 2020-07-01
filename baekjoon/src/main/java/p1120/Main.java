package p1120;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var a = sc.next();
		var b = sc.next();
		var c = b.length() - a.length();
		var k = Integer.MAX_VALUE;
		for (int i = 0; i <= c; i++) {
			var p = 0;
			var q = 0;
			while (p < a.length()) {
				if (a.charAt(p) != b.charAt(p + i)) q++;
				p++;
			}
			k = k > q ? q : k;
		}
		System.out.println(k);
	}
}