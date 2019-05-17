package p4564;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int s = sc.nextInt();
			if (s == 0) break;
			int t = 1;
			System.out.print(s);
			if (s < 10) {
				System.out.println();
				continue;
			}
			while (true) {
				t = t * (s % 10);
				s = s / 10;
				if (s < 1) {
					System.out.print(" " + t);
					if (t < 10) {
						break;
					}
					s = t;
					t = 1;
				}
			}
			System.out.println();
		}
	}
}