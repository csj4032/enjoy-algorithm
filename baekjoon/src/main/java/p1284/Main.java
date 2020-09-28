package p1284;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var sb = new StringBuilder();
		while (true) {
			var n = sc.next();
			var k = n.length() + 1;
			if (n.equals("0")) break;
			for (int i = 0; i < n.length(); i++) {
				if (n.charAt(i) == '1') {
					k += 2;
				} else if (n.charAt(i) == '0') {
					k += 4;
				} else {
					k += 3;
				}
			}
			sb.append(k + "\n");
		}
		System.out.println(sb.toString());
	}
}