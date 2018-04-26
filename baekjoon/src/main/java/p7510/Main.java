package p7510;

import java.util.Scanner;

public class Main {

	private static Scanner sc;
	private static int n;
	private static StringBuilder sb;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		n = sc.nextInt();
		sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			Long a = sc.nextLong();
			Long b = sc.nextLong();
			Long c = sc.nextLong();
			Long t;
			if (a > b) {
				t = b;
				b = a;
				a = t;
			}

			if (b > c) {
				t = c;
				c = b;
				b = t;
			}

			sb.append("Scenario #" + String.valueOf(i) + ":\n");
			sb.append(((a * a) + (b * b) == c * c ? "yes\n\n" : "no\n\n"));
		}

		System.out.print(sb.toString());
	}
}