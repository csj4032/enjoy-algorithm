package p9625;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] a = new long[46];
		long[] b = new long[46];

		a[0] = 1;
		a[1] = 0;

		b[0] = 0;
		b[1] = 1;

		for (int i = 2; i <= n; i++) {
			a[i] = a[i - 1] + a[i - 2];
			b[i] = b[i - 1] + b[i - 2];
		}

		System.out.print(a[n] + " " + b[n]);
	}
}