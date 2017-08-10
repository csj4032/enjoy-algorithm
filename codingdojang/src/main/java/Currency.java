import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Currency {

	final static Pattern pattern = Pattern.compile("(^[+-]?\\d+)(\\d{3})");

	public static void main(String[] args) {
		current(String.valueOf(1000));
		current(String.valueOf(20000000));
		current(String.valueOf(-3245.24));
	}

	private static void current(String number) {
		Matcher matcher = pattern.matcher(String.valueOf(number));
		String g1 = "", g2;

		if (matcher.find()) {
			g1 = matcher.group(1);
			g2 = matcher.group(2);
			number = number.replaceAll("(^[-]?\\d+)(\\d{3})", g1 + "," + g2);
		}

		if (g1.length() <= 3) {
			System.out.println(number);
			return;
		} else {
			current(number);
		}
	}
}

//number = number.replaceAll("(^[+-]?\\d+)(\\d{3})", "$1" + "," + "$2");