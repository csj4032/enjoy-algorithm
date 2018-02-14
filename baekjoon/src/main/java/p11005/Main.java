package p11005;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(decimal(n, m));
	}

	private static String decimal(int n, int m) {
		StringBuilder sb = new StringBuilder();
		while (n >= 1) {
			int mod = (n % m);
			if (mod > 9) {
				sb.insert(0, (char) (mod - 10 + 'A'));
			} else {
				sb.insert(0, (char) (mod + '0'));
			}
			n = (n - mod) / m;
		}

		return sb.toString();
	}
}