package p9546;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] m = new int[t];

		for (int i = 0; i < t; i++) {
			m[i] = sc.nextInt();
		}

		for (int i = 0; i < t; i++) {
			System.out.println(getPassenger(m[i]));
		}
	}

	private static int getPassenger(int seed) {
		double passenger = 0;
		while (seed > 0) {
			seed--;
			passenger = (passenger + 0.5) * 2;
		}
		return (int) passenger;
	}
}