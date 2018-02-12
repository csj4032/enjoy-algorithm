package p2447;

import java.util.Scanner;

public class Main {

	static String a = "***";
	static String b = "* *";
	static String c = "   ";
	static int nn;
	static int mm;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		mm = sc.nextInt();
		nn = mm / 3;

		if (mm == 1) {
			System.out.print("*");
			return;
		}

		for (int i = 0; i < nn; i++) {
			display(nn, i, a);
			display(nn, i, b);
			display(nn, i, a);
		}
	}

	private static void display(int n, int i, String s) {
		for (int k = 0; k < n; k++) {
			if (recursive(n, i, k)) {
				System.out.print(s);
			} else {
				System.out.print(c);
			}
		}
		System.out.println();
	}

	private static boolean recursive(int n, int i, int k) {
		while (n > 1) {
			if (((i / (nn / n)) % 3 == 1) && ((k / (nn / n)) % 3 == 1)) {
				return false;
			}
			n = n / 3;
		}
		return true;
	}
}