package p2293;

import java.util.Scanner;

public class Main2 {

	static int[] m;
	static int[] s;
	static int k;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		m = new int[101];
		s = new int[1001];

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		s[0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = m[i]; j <= k; j++) {
				s[j] += s[j - m[i]];
			}
		}

		System.out.println(s[k]);
	}
}