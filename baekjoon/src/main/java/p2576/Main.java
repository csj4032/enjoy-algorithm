package p2576;

import java.util.Scanner;

public class Main {

	static int n = 7;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] t = new int[n];

		for (int i = 0; i < n; i++) {
			t[i] = sc.nextInt();
		}

		int s = 0;
		int m = 99;
		for (int i = 0; i < n; i++) {
			if ((t[i] & 1) != 0) {
				s += t[i];
				if (m > t[i]) m = t[i];
			}
		}

		if (s == 0) {
			System.out.println("-1");
		} else {
			System.out.println(s);
			System.out.println(m);
		}
	}
}
