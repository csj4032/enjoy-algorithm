package p2985;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int c1 = a + b;
		int c2 = a - b;
		int c3 = a * b;
		int c4 = a / b;

		int a1 = b + c;
		int a2 = b - c;
		int a3 = b / c;
		int a4 = b * c;

		if (c == c1) {
			System.out.println(a + "+" + b + "=" + c);
		} else if (c == c2) {
			System.out.println(a + "-" + b + "=" + c);
		} else if (c == c3) {
			System.out.println(a + "*" + b + "=" + c);
		} else if (c == c4) {
			System.out.println(a + "/" + b + "=" + c);
		} else if (a == a1) {
			System.out.println(a + "=" + b + "+" + c);
		} else if (a == a2) {
			System.out.println(a + "=" + b + "-" + c);
		} else if (a == a3) {
			System.out.println(a + "=" + b + "/" + c);
		} else if (a == a4) {
			System.out.println(a + "=" + b + "*" + c);
		}
	}
}
