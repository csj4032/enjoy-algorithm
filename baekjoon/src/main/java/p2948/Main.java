package p2948;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	static String[] DAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int d = sc.nextInt();
		System.out.println(DAYS[LocalDate.of(2009, d, m).getDayOfWeek().getValue()-1]);
	}
}