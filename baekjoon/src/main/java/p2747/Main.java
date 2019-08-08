package p2747;

import java.util.Scanner;

public class Main {

	private static int[] fibonacci;

	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		fibonacci = new int[n + 1];
		fibonacci[1] = 1;
		for (int i = 2; i <= n; i++) {
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}
		System.out.println(fibonacci[n]);
	}

	private static int fibonacci(int i) {
		if (i == 0) return 0;
		if (i == 1) return 1;
		return fibonacci(i - 1) + fibonacci(i - 2);
	}
}