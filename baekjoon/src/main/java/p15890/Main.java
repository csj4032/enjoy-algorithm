package p15890;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {
		var localDateArray = LocalDate.of(2018, 7, 29).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		System.out.println(localDateArray);
	}
}
