package p10707;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int p = sc.nextInt();

		int x = a * p;
		int y = p > c ? ((p - c) * d) + b : b;

		System.out.println(Math.min(x, y));
	}
}