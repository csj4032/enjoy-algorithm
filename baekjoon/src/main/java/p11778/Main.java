package p11778;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] f = new int[1000000007];
		f[0] = 0;
		f[1] = 1;

		for (int i = 2; i <= n; i++) {
			f[i] = (f[i - 2] + f[i - 1]) % 1000000007;
		}

		System.out.println(f[n]);
	}
}
