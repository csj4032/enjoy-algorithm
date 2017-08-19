package p2747;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println(fibonacci(new Scanner(System.in).nextInt()));
	}

	private static int fibonacci(int i) {
		if (i == 0) return 0;
		if (i == 1) return 1;
		return fibonacci(i - 1) + fibonacci(i - 2);
	}
}