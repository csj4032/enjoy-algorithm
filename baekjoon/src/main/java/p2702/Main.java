package p2702;

import java.util.Scanner;

/**
 * 제목 : 초6 수학
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(lcm(a, b) + " " + gcd(a, b));
		}
	}

	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	private static int gcd(int a, int b) {
		if (b % a == 0) return a;
		return gcd(b % a, a);
	}
}