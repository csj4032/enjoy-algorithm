package p5545;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static Integer[] m = new Integer[100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = 0;
		int max = 0;

		Arrays.fill(m, 0);

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		Arrays.sort(m, Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			d += m[i];
			int k = (c + d) / (a + (b * (i + 1)));
			if (max < k) max = k;
		}

		System.out.println(max);
	}
}