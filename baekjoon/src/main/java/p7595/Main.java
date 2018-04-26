package p7595;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int k = sc.nextByte();
			if (k == 0) break;
			print(k);
		}
	}

	private static void print(int k) {
		for (int i = 0; i < k; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}