package p11047;

import java.util.Scanner;

public class Main {

	private static int n;
	private static int k;
	private static int[] coins;
	private static int min = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		coins = new int[n];

		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}

		for (int i = (n - 1); i >= 0; i--) {
			if (k >= coins[i]) {
				int m = k % coins[i];
				min += k / coins[i];
				if (m == 0) {
					break;
				} else {
					k = m;
				}
			}
		}
		System.out.println(min);
	}
}