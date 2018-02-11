package p10807;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n];

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		int k = sc.nextInt();
		int t = 0;
		for (int i = 0; i < n; i++) {
			if (m[i] == k) {
				t++;
			}
		}

		System.out.println(t);
	}
}