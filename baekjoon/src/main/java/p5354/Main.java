package p5354;

import java.util.Scanner;

// J박스
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] m = new int[t];

		for (int i = 0; i < t; i++) {
			m[i] = sc.nextInt();
		}

		for (int i = 0; i < t; i++) {
			jDisplay(m[i]);
			System.out.println();
		}
	}

	private static void jDisplay(int i) {
		for (int j = 0; j < i; j++) {
			for (int k = 0; k < i; k++) {
				if (j == 0 || j == i - 1 || k == 0 || k == i - 1) {
					System.out.print("#");
				} else {
					System.out.print("J");
				}
			}
			System.out.println();
		}
	}
}