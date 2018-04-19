package p1629;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		System.out.println(power(a, b, c));
	}

	private static long power(long a, long b, long c) {
		a %= c;
		if (b == 0) return 1;
		if (b % 2 == 0) {
			return power(a * a, b >> 1, c) % c;
		} else {
			return a * power(a * a, (b - 1) >> 1, c) % c;
		}
	}
}