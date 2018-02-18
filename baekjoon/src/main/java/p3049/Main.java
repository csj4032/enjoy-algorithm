package p3049;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		System.out.println(n * (n - 1) * (n - 2) * (n - 3) / 24);
	}
}