package p10815;

import java.util.Scanner;

public class Main {

	private static int[] k = new int[20000000];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int l = sc.nextInt();
			k[l + 10000000] = 1;
		}

		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			int l = sc.nextInt();
			System.out.print(k[l + 10000000]);
			if (i != m - 1) System.out.print(" ");
		}
	}
}
