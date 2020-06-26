package p10173;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);

		while (true) {
			String line = sc.nextLine();
			if (line.equals("EOI")) break;
			findNemo(line);
		}
		sc.close();
	}

	private static void findNemo(String line) {
		Pattern pattern = Pattern.compile("^.*\\b(nemo)\\b.*$");
		Matcher matcher = pattern.matcher(line.toLowerCase());
		if (matcher.find()) {
			System.out.println("Found");
		} else {
			System.out.println("Missing");
		}
	}
}