package p2475;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] numbers = sc.nextLine().split(" ");
		long total = 0;
		for (int i = 0; i < numbers.length; i++) {
			total += Math.pow(Long.parseLong(numbers[i]), 2);
		}
		System.out.println(total%10);
	}
}