import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalFormatter {

	public static void main(String[] args) {
		String numbers = "-111111132.00";
		Pattern p = Pattern.compile("(-?)\\d*");

		Matcher m = p.matcher(numbers);

		Deque<String> s = new ArrayDeque<>();

		while (m.find()) {
			System.out.println(m.group());
		}

		while (!s.isEmpty()) {
			if(!s.pollLast().contains(".")) {
			}
			System.out.println(s.pollLast());
		}

	}
}