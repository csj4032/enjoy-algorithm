package p2446;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int m = (2 * new Scanner(System.in).nextInt()) - 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (j >= i && j < m - i) {
					System.out.print("*");
				} else if (j >= (m - i - 1) && j < i + 1) {
					System.out.print("*");
				} else {
					if (i > j) System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}