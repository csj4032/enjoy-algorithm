package p3076;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		int w = c * b;
		int h = r * a;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if ((j / b) % 2 == 0) {
					if ((i / a) % 2 == 0) {
						System.out.print("X");
					} else {
						System.out.print(".");
					}
				} else {
					if ((i / a) % 2 != 0) {
						System.out.print("X");
					} else {
						System.out.print(".");
					}
				}
			}
			System.out.println();
		}
	}
}