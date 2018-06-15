package p1940;

import java.util.Scanner;

public class Main {

	private static int n;
	private static int m;
	private static int k;
	private static int nm[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = 0;
		nm = new int[n];

		for (int i = 0; i < n; i++) nm[i] = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (m == nm[i] + nm[j]) {
					k++;
				}
			}
		}
		System.out.println(k);
	}
}