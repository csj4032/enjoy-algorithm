package p1978;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = 0;
		for (int i = 0; i < n; i++) {
			m += isPrime(sc.nextInt());
		}
		System.out.println(m);
	}

	private static int isPrime(int n) {
		if (n <= 1) return 0;
		for (int i = 2; i < n - 1; i++) {
			if (n % i == 0)
				return 0;
		}
		return 1;
	}
}
