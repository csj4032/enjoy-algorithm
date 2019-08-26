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
		z(0, 0, (int) Math.pow(2, n));
	}

	private static void z(int x, int y, int d) {
		if (x == c && y == r) {
			System.out.println(t);
			return;
		}
		if (d == 1) {
			t++;
			return;
		}
		z(x, y, d / 2);
		z(x + d / 2, y, d / 2);
		z(x, y + d / 2, d / 2);
		z(x + d / 2, y + d / 2, d / 2);
	}
}