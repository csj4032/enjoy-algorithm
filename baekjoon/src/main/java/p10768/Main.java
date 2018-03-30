package p10768;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	static LocalDate ccc = LocalDate.of(2015, 2, 18);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		int dayOfMonth = sc.nextInt();
		LocalDate input = LocalDate.of(2015, month, dayOfMonth);

		if (input.equals(ccc)) {
			System.out.println("Special");
		} else if (input.isAfter(ccc)) {
			System.out.println("After");
		} else if (input.isBefore(ccc)) {
			System.out.println("Before");
		}
	}
}