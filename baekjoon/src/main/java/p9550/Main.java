package p9550;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] m = new int[n];
			for (int j = 0; j < n; j++) {
				m[j] = sc.nextInt();
			}

			int p = 0;
			for (int j = 0; j < n; j++) {
				p += m[j] / k;
			}

			System.out.println(p);
		}
	}
}