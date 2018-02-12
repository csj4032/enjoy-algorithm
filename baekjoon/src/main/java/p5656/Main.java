package p5656;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = 1;
		while (true) {

			int a = sc.nextInt();
			String b = sc.next();
			int c = sc.nextInt();

			if (b.equals(">")) {
				System.out.printf("Case %d: %s\n", k, a > c);
				k++;
			}

			if (b.equals(">=")) {
				System.out.printf("Case %d: %s\n", k, a >= c);
				k++;
			}

			if (b.equals("<")) {
				System.out.printf("Case %d: %s\n", k, a < c);
				k++;
			}

			if (b.equals("<=")) {
				System.out.printf("Case %d: %s\n", k, a <= c);
				k++;
			}

			if (b.equals("==")) {
				System.out.printf("Case %d: %s\n", k, a == c);
				k++;
			}

			if (b.equals("!=")) {
				System.out.printf("Case %d: %s\n", k, a != c);
				k++;
			}

			if (b.equals("E")) break;
		}
	}
}