package p5532;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();

		int i = getDays(a, c);
		int j = getDays(b, d);

		System.out.println(l - Math.max(i, j));
	}

	private static int getDays(int a, int c) {
		int i = a / c;
		if (a % c > 0) i++;
		return i;
	}
}