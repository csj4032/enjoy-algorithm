package p2693;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			boolean[] m = new boolean[1000];
			int c = 0;

			for (int j = 0; j < 10; j++) {
				m[1000 - sc.nextInt()] = true;
			}

			for (int j = 0; j < 1000; j++) {
				if (m[j]) c++;

				if (c == 3) {
					System.out.println(1000 - j);
					break;
				}
			}
		}
	}
}