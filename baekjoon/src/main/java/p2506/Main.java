package p2506;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = 0;
		int k = 1;

		for (int i = 0; i < n; i++) {
			int p = sc.nextInt();
			if (p == 1) {
				m += k;
				k++;
			} else {
				k = 1;
			}
		}
		System.out.println(m);
	}
}