package p11509;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n];
		int l = 0;

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			int t = m[i];
			if (t == 0) continue;
			for (int j = i; j < n; j++) {
				if (m[j] != 0 && t - 1 == m[j]) {
					t = t - 1;
					m[j] = 0;
					l++;
				}
			}
		}
		System.out.println(n - l);
	}
}