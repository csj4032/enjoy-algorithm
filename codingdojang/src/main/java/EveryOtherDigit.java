import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* URL : http://codingdojang.com/scode/428
* URL : http://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html Groups and capturing
* */
public class EveryOtherDigit {
	public static void main(String[] args) {
		String i = "a1b2cde3~g45hi6";
		String[] r = i.split("");
		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher(i);
		while (m.find()) {
			if (m.start() % 2 != 0) r[m.start()] = "*";
		}
		System.out.println(String.join("", Arrays.asList(r)));
		System.out.println(i.replaceAll("((.\\D*))\\d((.\\D)*)", "$2*$4"));
	}
}
