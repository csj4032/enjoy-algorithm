package p15781;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = getMax(sc, n);
		int j = getMax(sc, m);
		System.out.println(k + j);
	}

	private static int getMax(Scanner sc, int m) {
		int j = 0;
		for (int i = 0; i < m; i++) {
			int t = sc.nextInt();
			if (j < t) j = t;
		}
		return j;
	}
}
