package p1929;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();

		for (int i = m; i <= n; i++) {
			if (prime(i)) System.out.println(i);
		}
	}

	private static boolean prime(int i) {
		if (i < 2 || (i != 2 && i % 2 == 0)) return false;
		int s = (int) Math.sqrt(i);
		for (int j = 3; j <= s; j += 2) {
			if (i % j == 0) return false;
		}
		return true;
	}
}