package p2447;

import java.util.Scanner;

public class Main {

	static String a = "***";
	static String b = "* *";
	static String c = "***";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() / 3;

		for (int j = 0; j < n; j++) {

			for (int i = 0; i < n; i++) {
				System.out.print(a);
			}

			System.out.println();

			for (int i = 0; i < n; i++) {
				System.out.print(b);
			}

			System.out.println();

			for (int i = 0; i < n; i++) {
				System.out.print(c);
			}

			System.out.println();
		}
	}
}
