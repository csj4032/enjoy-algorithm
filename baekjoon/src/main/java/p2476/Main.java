package p2476;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int t = 0;
			if (a == b && b == c) {
				t = 10000 + (a * 1000);
			} else if (a == b || b == c || a == c ) {
				if (a == c) {
					t = 1000 + a * 100;
				} else {
					t = 1000 + b * 100;
				}
			} else {
				t = Math.max(Math.max(a, b), c) * 100;
			}
			max = Math.max(max, t);
		}
		System.out.println(max);
	}
}
