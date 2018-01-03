package p1021;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int count = 0;

		for (int i = 0; i < m; i++) {
			int index = sc.nextInt() + count;
			count = (1 + i - index) <= (n - i + 1 - index) ? (1 + i - index) : (n - i + 1 - index);
			System.out.println(count);
			n = n - 1;
		}

		System.out.println(count);
	}
}