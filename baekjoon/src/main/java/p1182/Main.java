package p1182;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long k = sc.nextInt();
		int[] m = new int[n];
		int t = 0;

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		int s = (int) (Math.pow(2, n + 1) - Math.pow(2, n));
		int e = (int) (Math.pow(2, n + 1));

		for (int i = s + 1; i < e; i++) {
			String[] p = Integer.toBinaryString(i).split("");
			long sum = 0;
			for (int j = 1; j < p.length; j++) {
				if (p[j].equals("1")) {
					sum += m[j - 1];
				}
			}
			if (sum == k) {
				t++;
			}
		}

		System.out.print(t);
	}
}