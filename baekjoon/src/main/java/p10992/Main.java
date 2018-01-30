package p10992;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = n * 2 - 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == n - 1 || m - j == n - i || n - j - 1 == i) {
					System.out.print("*");
				} else {
					if (m - n + i > j) System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}
