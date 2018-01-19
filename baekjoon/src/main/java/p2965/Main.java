package p2965;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();

		int a = m - l;
		int b = n - m;

		int max = Math.max(a, b);

		System.out.println(max - 1);
	}
}