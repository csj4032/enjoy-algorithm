package p16170;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {
		var localDateArray = LocalDate.now().format(DateTimeFormatter.ISO_DATE).split("-");
		System.out.println(localDateArray[0]);
		System.out.println(localDateArray[1]);
		System.out.println(localDateArray[2]);
	}
}
