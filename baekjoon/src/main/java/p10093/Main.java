package p10093;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long diff = Math.abs(a - b) - 1;
		StringBuilder sb = new StringBuilder();

		if (a > b) a = b;

		for (long i = 0; i < diff; i++) {
			sb.append(i + a + 1);
			sb.append(' ');
		}

		System.out.println(diff == -1 ? 0 : diff);
		System.out.println(sb.toString());
	}
}