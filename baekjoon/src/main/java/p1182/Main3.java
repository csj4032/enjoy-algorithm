package p1182;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] m = new int[n];
		int t = 0;

		for (int i = 0; i < n; i++) m[i] = sc.nextInt();

		for (int i = 1; i < (1 << (n)); i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				System.out.println(j + " " + i + " " + Integer.toBinaryString(1 << j) + " " + Integer.toBinaryString(i) + " " + Integer.toBinaryString(i & (1 << j)));
				if (0 < (i & (1 << j))) {
					sum += m[j];
				}
			}
			System.out.println("");
			if (sum == k) t++;
		}

		System.out.print(t);
	}
}