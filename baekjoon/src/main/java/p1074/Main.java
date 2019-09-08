package p1074;

import java.util.Scanner;

public class Main {

	static int t = 0;
	static int n = 0;
	static int r = 0;
	static int c = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		z(n = 1 << n, 0, 0);
	}

	private static void z(int n, int x, int y) {
		if (n >> 1 == 0) {
			if (y == r && x == c) {
				System.out.print(t);
				return;
			}
			t++;
			return;
		}

		z(n / 2, x, y);
		z(n / 2, x + (n / 2), y);
		z(n / 2, x, y + (n / 2));
		z(n / 2, x + (n / 2), y + (n / 2));
	}
}