package p4153;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == 0 && b == 0 && c == 0) break;

			double a2 = Math.pow(a, 2);
			double b2 = Math.pow(b, 2);
			double c2 = Math.pow(c, 2);

			if (a2 + b2 == c2 || a2 + c2 == b2 || b2 + c2 == a2) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}
}
