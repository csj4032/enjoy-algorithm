package p1629;

import java.util.Scanner;

public class Main {

	static int[] m = new int[1000000000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int k = a % c;
		int t = a;

		m[0] = k;

		for (int i = 1; i < b; i++) {
			k = (a * k) % c;
			System.out.print(k + " ");
			if (m[0] == k) {
				t = i;
				//break;
			}
			m[i] = k;
		}

		System.out.println();
		System.out.println(m[(b % t) + 1]);
		System.out.println(Math.pow(a, b) % c);
	}
}