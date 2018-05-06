package p10822;

import java.util.Scanner;

public class Main {

	static long n = 0;

	public static void main(String[] args) {
		String[] numbers = new Scanner(System.in).nextLine().split(",");
		for (int i = 0; i < numbers.length; i++) n += Long.parseLong(numbers[i]);
		System.out.print(n);
	}
}