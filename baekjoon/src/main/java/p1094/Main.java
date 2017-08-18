package p1094;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println(recursive(64, new Scanner(System.in).nextInt(), 0));
	}

	private static int recursive(int a, int b, int c) {
		if (a - b == 0) {
			c = c + 1;
			return c;
		}
		if (a > b) {
			a = a / 2;
			return recursive(a, b, c);
		} else {
			c = c + 1;
			b = b - a;
			a = a / 2;
			return recursive(a, b, c);
		}
	}
}