package p3053;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		System.out.printf("%6f", Math.PI * r * r);
		System.out.println();
		System.out.printf("%6f", 2d * r * r);
	}
}
