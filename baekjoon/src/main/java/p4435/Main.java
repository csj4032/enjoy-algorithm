package p4435;

import java.util.Scanner;

public class Main {

	static int[] h = new int[]{1, 2, 3, 3, 4, 10};
	static int[] v = new int[]{1, 2, 2, 2, 3, 5, 10};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			int t = 0;
			int k = 0;
			String s = "No victor on this battle field";
			for (int j = 0; j < 6; j++) {
				int q = sc.nextInt();
				t += q * h[j];
			}

			for (int j = 0; j < 7; j++) {
				int q = sc.nextInt();
				k += q * v[j];
			}

			if (t < k) {
				s = "Evil eradicates all trace of Good";
			} else if (t > k) {
				s = "Good triumphs over Evil";
			}

			System.out.printf("Battle %s: " + s + "\n", i + 1);
		}
	}
}