package p9325;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			long s = sc.nextLong();
			int n = sc.nextInt();
			for (int j = 0; j < n; j++) {
				s += sc.nextLong() * sc.nextLong();
			}
			System.out.println(s);
		}
	}
}