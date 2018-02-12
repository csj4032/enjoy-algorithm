package p5347;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			System.out.println(lcm(sc.nextLong(), sc.nextLong()));
		}
	}

	private static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

	private static long gcd(long a, long b) {
		if (a % b == 0) return b;
		return gcd(b, a % b);
	}
}