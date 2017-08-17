package p2609;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		int gcd = gcd(n, m);
		System.out.println(gcd);
		System.out.println(lcm(n, m, gcd));
	}

	private static int gcd(int n, int m) {
		int a = Math.max(n, m);
		int b = Math.min(n, m);
		if (a % b == 0) return b;
		return gcd(b, a % b);
	}

	private static int lcm(int n, int m, int gcd) {
		return (n * m / gcd);
	}
}