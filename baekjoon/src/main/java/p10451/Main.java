package p10451;

import java.util.Arrays;
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
				while (m[j] != k) {
					k = m[k] - 1;
					if (k == m[j]) {
						s++;
					}
				}
			}
			System.out.println(s);
		}
	}
}
