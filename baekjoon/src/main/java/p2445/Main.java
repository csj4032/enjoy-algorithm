package p2445;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int h = n * 2 - 1;
		int w = n * 2;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if(i < n) {
					if (j <= i || (w - i - 1) <= j) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				} else {
					if (j > i || (w - i - 1) > j) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println("");
		}
	}
}