package p10820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws IOException {

		Pattern p1 = Pattern.compile("([a-z])");
		Pattern p2 = Pattern.compile("([A-Z])");
		Pattern p3 = Pattern.compile("(\\d)");
		Pattern p4 = Pattern.compile("(\\s)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;
		while ((line = br.readLine()) != null) {

			int c1 = 0;
			int c2 = 0;
			int c3 = 0;
			int c4 = 0;

			Matcher m1 = p1.matcher(line);
			Matcher m2 = p2.matcher(line);
			Matcher m3 = p3.matcher(line);
			Matcher m4 = p4.matcher(line);

			while (m1.find()) {
				c1++;
			}
			while (m2.find()) {
				c2++;
			}
			while (m3.find()) {
				c3++;
			}
			while (m4.find()) {
				c4++;
			}

			System.out.println(c1 + " " + c2 + " " + c3 + " " + c4);
		}
	}
}