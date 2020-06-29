package p15964;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = (a + b) * (a - b);
		System.out.println(c);
	}
}
