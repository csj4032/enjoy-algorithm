package p12755;

import java.util.Scanner;

public class Main {

	private static int k;
	private static int n;
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			String s = String.valueOf(i);
			k += s.length();
			if (k >= n) {
				System.out.println(s.charAt(s.length() - (k - n) - 1));
				break;
			}
		}
	}
}