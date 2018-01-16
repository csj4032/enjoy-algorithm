package p2442;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = 2 * n - 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (n - i - 1 <= j && j <= m - n + i) {
					System.out.print("*");
				} else if (n - i > j) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}