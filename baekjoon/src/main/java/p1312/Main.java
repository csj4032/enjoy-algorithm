package p1312;

import java.util.Scanner;

public class Main {

	static int length = 1000000;
	static int decimals[] = new int[length];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		int c = a / b;
		int d = (a - b * c) * 10;
		for (int i = 0; i < length; i++) {
			c = d / b;
			d = (d - b * c) * 10;
			decimals[i] = c;
		}
		System.out.println(decimals[n-1]);
	}
}