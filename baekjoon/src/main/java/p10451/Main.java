package p10451;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] m = new int[n];
			int s = 0;
			for (int j = 0; j < n; j++) {
				m[j] = sc.nextInt();
			}
			for (int j = 0; j < n; j++) {
				int k = m[j];
				int l = j;
				while (true) {
					l = m[l] - 1;
					if (l < 0) break;
					if (k == m[l]) {
						s++;
						m[l] = 0;
						break;
					}
				}
			}
			System.out.println(s);
		}
	}
}