package p10420;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println(LocalDate.of(2014, 4, 2).plusDays(new Scanner(System.in).nextInt()).minusDays(1));
	}
}