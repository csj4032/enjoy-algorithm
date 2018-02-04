package p14630;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] m = new String[1001];
		int k = 0;

		for (int i = 1; i <= n; i++) {
			m[i] = sc.next();
		}

		int from = sc.nextInt();
		int to = sc.nextInt();

		for (int i = from; i < to; i++) {
			k += calculate(m[i], m[i + 1]);
		}

		System.out.println(k);
	}

	private static int calculate(String a, String b) {
		int r = 0;
		for (int i = 0; i < b.length(); i++) {
			int q = Integer.parseInt(a.substring(i, i + 1));
			int t = Integer.parseInt(b.substring(i, i + 1));
			r += (int) Math.pow(q - t, 2);
		}

		//System.out.println(q + " " + q1 + " " + t + " " + t1);

		return r;
	}
}