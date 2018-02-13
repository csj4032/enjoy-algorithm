package p10995;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = n * 2;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ((i & 1) == 0 && (j & 1) == 0 || (i & 1) != 0 && (j & 1) != 0) {
					System.out.print("*");
				} else {
					if (j < m - 1) System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}