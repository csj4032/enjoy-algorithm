package p2588;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = 0;

		for (int i = 1; i < 4; i++) {
			int k = m % (int) Math.pow(10, i);
			m = m - k;
			l = l + n * k;
			System.out.println(n * k / (int) Math.pow(10, i - 1));
		}
		System.out.println(l);
	}
}
