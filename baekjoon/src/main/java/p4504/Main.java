package p4504;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		while (true) {
			int l = sc.nextInt();
			if (l == 0) break;
			if (l % n != 0) {
				System.out.printf("%d is NOT a multiple of %d.\n", l, n);
			} else {
				System.out.printf("%d is a multiple of %d.\n", l, n);
			}
		}
	}
}