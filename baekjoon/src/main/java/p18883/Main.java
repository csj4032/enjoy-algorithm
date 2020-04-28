package p18883;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.nextInt();
		var sb = new StringBuilder();
		for (int i = 1; i <= n * m; i++) {
			sb.append(i);
			if (i % m == 0) {
				sb.append("\n");
			} else {
				sb.append(" ");
			}
		}
		System.out.println(sb.toString());
	}
}
