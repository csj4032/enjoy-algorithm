package p5724;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0) break;
			System.out.println(square(n));
		}
	}

	private static int square(int n) {
		int k = 0;
		while (n > 0) {
			k += n * n;
			n--;
		}
		return k;
	}

	private static int square2(int n) {
		return n * (n + 1) * (2 * n + 1) / 6;
	}
}