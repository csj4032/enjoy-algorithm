package p9306;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			var last = sc.next();
			var first = sc.next();
			sb.append("Case " + i + ": " + first + ", " + last + "\n");
		}
		System.out.println(sb.toString());
	}
}
