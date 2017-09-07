package p2293;

import java.util.Scanner;

public class Main {

	static int[] m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		m = new int[n];
		for (int i = 0; i < n; i++) m[i] = sc.nextInt();
		System.out.println(recursive(k, 0));
	}

	private static int recursive(int k, int s) {
		if (k == 0) return 1;
		else if (k < 0 || m.length <= s) return 0;
		return recursive(k - m[s], s) + recursive(k, s + 1);
	}
}