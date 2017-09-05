package p2579;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] m = new int[n];
//		for (int i = 0; i < n; i++) {
//			m[i] = sc.nextInt();
//		}
		int n = 6;
		int[] m = {10, 20, 15, 25, 10, 20};
		recursive(n, m, 1);
	}

	private static void recursive(int n, int[] m, int s) {
		if (s > n) {
			return;
		}
		System.out.println(m[s]);
		recursive(n, m, s + 1);
	}
}