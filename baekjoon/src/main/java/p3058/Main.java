package p3058;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int min = 101;
			int sum = 0;
			for (int j = 0; j < 7; j++) {
				int n = sc.nextInt();
				if (n % 2 == 0) {
					sum += n;
					if (n < min) min = n;
				}
			}
			System.out.println(sum + " " + min);
		}
	}
}