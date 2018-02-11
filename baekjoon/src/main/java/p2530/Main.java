package p2530;

import java.util.Scanner;

public class Main {

	static int pp = 24;
	static int qq = 60;
	static int kk = 3600;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		int t = sc.nextInt();

		int tt = (h * kk) + (m * qq) + s + t;

		int ss = tt % qq;
		int mm = (tt - ss) / qq % qq;
		int hh = ((tt - ss - (mm * qq)) / kk) % pp;

		System.out.printf("%s %s %s", hh, mm, ss);
	}
}