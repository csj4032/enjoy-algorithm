package p1547;

import java.util.Scanner;

public class Main {

	private static int n;
	private static int k;
	private static int p;
	private static int q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = 1;
		for (int i = 0; i < n; i++) {
			p = sc.nextInt();
			q = sc.nextInt();
			if (p == k) {
				k = q;
			} else if (q == k) {
				k = p;
			}
		}
		System.out.println(k);
	}
}