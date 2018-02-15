package p11441;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nn = new int[n];
		int[] ss = new int[n + 1];

		ss[0] = 0;

		for (int i = 0; i < n; i++) {
			nn[i] = sc.nextInt();
			ss[i + 1] = ss[i] + nn[i];
		}

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			System.out.println(ss[e] - ss[s - 1]);
		}
	}
}