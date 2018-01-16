package p2523;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = 2 * n - 1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= j && i < n) {
					System.out.print("*");
				} else if (i >= n && j > i - n) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
