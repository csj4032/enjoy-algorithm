package p3036;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < n - 1; i++) {
			int k = sc.nextInt();
			int gcd = gcd(m, k);
			System.out.println(m / gcd + "/" + k / gcd);
		}
	}

	private static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}
}