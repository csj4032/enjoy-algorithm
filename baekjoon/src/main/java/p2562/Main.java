package p2562;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] m = new int[9];

		for (int i = 0; i < 9; i++) {
			m[i] = sc.nextInt();
		}

		int idx = 0;
		int max = 0;
		for (int i = 0; i < 9; i++) {
			if (max < m[i]) {
				max = m[i];
				idx = i;
			}
		}

		System.out.println(max);
		System.out.println(idx + 1);
	}
}