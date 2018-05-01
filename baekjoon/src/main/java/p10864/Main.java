package p10864;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] l = new int[n + 1];

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			l[a] += 1;
			l[b] += 1;
		}

		for (int i = 1; i <= n; i++) {
			System.out.println(l[i]);
		}
	}
}
