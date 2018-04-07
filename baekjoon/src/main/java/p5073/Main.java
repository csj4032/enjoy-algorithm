package p5073;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == 0 && b == 0 && c == 0) {
				break;
			}

			if (a + b > c && a + c > b && b + c > b) {
				if (a == b && a == c && c == b) {
					System.out.println("Equilateral");
				} else if (a != b && a != c && c != b) {
					System.out.println("Scalene");
				} else {
					System.out.println("Isosceles");
				}
			} else {
				System.out.println("Invalid");
			}
		}
	}
}