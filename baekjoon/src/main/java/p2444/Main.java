package p2444;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = (2 * n) - 1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (j < n) {
					if (i < n) {
						if (n - i - 1 <= j) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					} else {
						if (i - n + 1 > j) {
							System.out.print(" ");
						} else {
							System.out.print("*");
						}
					}
				} else {
					if (i < n) {
						if (j - n < i) {
							System.out.print("*");
						}
					} else {
						if (j < (m - (i - n)) - 1) {
							System.out.print("*");
						}
					}
				}
			}
			System.out.println("");
		}
	}
}