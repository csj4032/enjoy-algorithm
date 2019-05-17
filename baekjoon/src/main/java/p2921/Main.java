package p2921;

import java.util.Scanner;

public class Main {

	static int k = 0;

	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		for (int i = 0; i < n; i++) {
			k += (n - i + 1) * (i + 1);
			for (int j = i + 1; j <= n; j++) {
				k += j;
			}
		}
		System.out.println(k);
	}
}