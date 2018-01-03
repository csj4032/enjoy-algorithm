package p9095;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(recursive(sc.nextInt()));
		}
	}

	private static int recursive(int n) {
		if (n < 0) return 0;
		if (n == 0) return 1;
		return recursive(n - 1) + recursive(n - 2) + recursive(n - 3);
	}
}