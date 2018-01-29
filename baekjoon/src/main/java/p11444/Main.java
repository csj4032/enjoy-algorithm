package p11444;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();

		int[] f = new int[1000000007];
		f[0] = 0;
		f[1] = 1;

		int m = (int) (n % 1000000007);
		for (int i = 2; i < m; i++) {
			f[i] = (f[i - 2] + f[i - 1]) % 1000000007;
		}
		System.out.println(f[m]);
	}
}