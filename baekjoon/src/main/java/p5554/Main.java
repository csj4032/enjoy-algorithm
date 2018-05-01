package p5554;

import java.util.Scanner;

public class Main {

	static int a = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			a += sc.nextInt();
		}
		System.out.println((a) / 60);
		System.out.println((a) % 60);
	}
}