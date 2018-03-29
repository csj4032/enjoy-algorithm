package p14916;

import java.util.Scanner;

/**
 * DP 다시 풀어 봅시다.
 */
public class Main {

	public static void main(String[] args) {
		change(new Scanner(System.in).nextInt());
	}

	private static void change(int n) {
		if (n == 1 || n == 3) {
			System.out.println(-1);
		} else if (n % 5 == 0) {
			System.out.println(n / 5);
		} else if (n % 5 == 1) {
			System.out.println((n / 5) + 2);
		} else if (n % 5 == 2) {
			System.out.println((n / 5) + 1);
		} else if (n % 5 == 3) {
			System.out.println((n / 5) + 3);
		} else if (n % 5 == 4) {
			System.out.println((n / 5) + 2);
		}
	}
}