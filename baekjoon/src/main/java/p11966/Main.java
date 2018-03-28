package p11966;

import java.util.Scanner;

public class Main {

	static float n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextFloat();

		while (true) {
			if (n == 1) {
				System.out.println(1);
				return;
			}
			if (n % 1 != 0) {
				System.out.println(0);
				return;
			}
			n = n / 2;
		}
	}
}