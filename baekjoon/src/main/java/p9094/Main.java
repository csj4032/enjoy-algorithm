package p9094;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(solve(n, m));
		}
	}

	private static int solve(int n, int m) {
		int c = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				int a = (i + 1);
				int b = (j + 1);
				if (((a * a) + (b * b) + m) % (a * b) == 0) {
					c++;
				}
			}
		}
		return c;
	}
}