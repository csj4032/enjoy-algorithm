package p5063;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (a > b - c) {
				System.out.println("do not advertise");
			}
			if (a == b - c) {
				System.out.println("does not matter");
			}
			if (a < b - c) {
				System.out.println("advertise");
			}
		}
	}
}