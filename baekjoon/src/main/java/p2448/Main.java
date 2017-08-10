package p2448;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		int n = sc.nextInt();
		star(n);
	}

	private static void star(int n) {
		System.out.println("  *  ");
		System.out.println("     ");
		System.out.println(" * * ");
		System.out.println("     ");
		System.out.println("*****");
	}
}
