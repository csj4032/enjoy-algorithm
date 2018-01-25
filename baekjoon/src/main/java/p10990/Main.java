package p10990;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = n * 2 - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ((n - 1) - i == j || (n - 1) + i == j) {
					System.out.print("*");
				} else {
					if((n - 1) + i > j) System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}