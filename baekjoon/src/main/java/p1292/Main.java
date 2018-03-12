package p1292;

import java.util.Scanner;

public class Main {

	static int[] k = new int[500500];
	static int t = 0;
	static int p = 0;

	public static void main(String[] args) {

		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < i + 1; j++) {
				k[t] = i + 1;
				t++;
			}
		}

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		for (int i = n; i <= m; i++) {
			p += k[i - 1];
		}

		System.out.println(p);
	}
}