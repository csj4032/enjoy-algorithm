import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class PotholeCase {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("[A-Z,0-9]");
		Matcher m = p.matcher(new Scanner(in).next());
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "_" + m.group().toLowerCase());
		}
		m.appendTail(sb);
		System.out.println(sb.toString());
	}
}