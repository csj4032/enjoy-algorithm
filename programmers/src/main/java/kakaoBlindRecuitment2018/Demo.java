package kakaoBlindRecuitment2018;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {

	private static Pattern pointPattern = Pattern.compile("^.*?(\\d+)([S|D|T])(\\*|#)?");

	public static void main(String[] args) {
		Matcher pointMatcher = pointPattern.matcher("1S");
		while (pointMatcher.find()) {
			System.out.println(pointMatcher.group(1));
			System.out.println(pointMatcher.group(2));
			System.out.println(pointMatcher.group(3));
		}
	}
}
