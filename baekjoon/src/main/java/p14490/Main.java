package p14490;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] k = sc.next().split(":");
		int n = Integer.valueOf(k[0]);
		int m = Integer.valueOf(k[1]);
		int g = gcd(n, m);
		System.out.printf("%d:%d", n / g, m / g);
	}

	private static int gcd(int p, int q) {
		if (q == 0) return p;
		return gcd(q, p % q);
	}
}