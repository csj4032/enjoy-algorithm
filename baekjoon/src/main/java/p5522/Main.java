package p5522;

import java.util.Scanner;

public class Main {

	static int k = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			k += sc.nextInt();
		}
		System.out.println(k);
	}
}