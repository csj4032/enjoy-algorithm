package p10409;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		int m = 0, l = 0;
		for (int i = 0; i < n; i++) {
			m += sc.nextInt();
			if (t < m) break;
			l++;
		}
		System.out.println(l);
	}
}