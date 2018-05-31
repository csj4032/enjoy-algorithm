package p5597;

import java.util.Scanner;

public class Main {

	static boolean[] b = new boolean[30];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 28; i++) {
			b[sc.nextInt()] = true;
		}
	}
}