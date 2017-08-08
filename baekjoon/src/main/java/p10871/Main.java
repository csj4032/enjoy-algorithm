package baekjoon.p10871;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			if (m > k) {
				System.out.print(k + " ");
			}
		}
	}
}
