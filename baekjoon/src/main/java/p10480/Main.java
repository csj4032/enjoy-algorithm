package p10480;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			if ((n & 1) == 0) {
				System.out.println(n + " is even");
			} else {
				System.out.println(n + " is odd");
			}
		}
	}
}