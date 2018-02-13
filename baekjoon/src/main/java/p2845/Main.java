package p2845;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		int np = n * p;

		int a = sc.nextInt() - np;
		int b = sc.nextInt() - np;
		int c = sc.nextInt() - np;
		int d = sc.nextInt() - np;
		int e = sc.nextInt() - np;

		System.out.println(a + " " + b + " " + c + " " + d + " " + e);
	}
}