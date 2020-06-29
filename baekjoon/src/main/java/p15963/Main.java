package p15963;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();
		if (n == m) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
