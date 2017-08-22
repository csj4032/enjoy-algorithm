package p10989;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		int[] m1 = new int[n];

		for (int i = 0; i < n; i++) {
			int min = sc.nextInt();
			m1[i] = min;
			if (max < min) {
				max = min;
			}
		}

		int[] m2 = new int[max+1];
		for (int i = 0; i < n; i++) {
			m2[m1[i]]++;
		}

		for (int i = 0; i < m2.length; i++) {
			int k = m2[i];
			for (int j = 0; j < k; j++) {
				System.out.println(i);
			}
		}
	}
}