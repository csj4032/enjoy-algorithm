package p1934;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println((a * b) / gcd(a, b));
		}
	}

	private static int gcd(int a, int b) {
		if (b % a == 0) return a;
		return gcd(b % a, a);
	}
}