package p10699;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD")));
	}
}