package p1748;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = String.valueOf(n).length();
		int l = 0;

		int k = (n + 1 - (int) Math.pow(10, m - 1)) * m;

		for (int i = 0; i < m - 1; i++) {
			l += (9 * (long) Math.pow(10, i)) * (i + 1);
		}

		System.out.println(l + k);
	}
}