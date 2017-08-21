package p10989;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m2 = new int[10000];
		for (int i = 0; i < n; i++) {
			m2[sc.nextInt()-1] += 1;
		}

		for (int i = 0; i < 10000; i++) {
			int k = m2[i];
			for (int j = 0; j < k; j++) {
				System.out.println(i + 1);
			}
		}
	}
}