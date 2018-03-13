package p10156;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int g = sc.nextInt() * sc.nextInt() - sc.nextInt();
		System.out.println(g < 0 ? 0 : g);
	}
}