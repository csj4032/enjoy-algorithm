import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneNumber {

	public static final Collector<String, ?, Map<String, Long>> STRING_MAP_COLLECTOR = Collectors.groupingBy(String::new, Collectors.counting());

	static Map<String, Integer> table = new HashMap<>();

	static {
		table.put("A", 2);
		table.put("B", 2);
		table.put("C", 2);

		table.put("D", 3);
		table.put("E", 3);
		table.put("F", 3);

		table.put("G", 4);
		table.put("H", 4);
		table.put("I", 4);

		table.put("J", 5);
		table.put("K", 5);
		table.put("L", 5);

		table.put("M", 6);
		table.put("N", 6);
		table.put("O", 6);

		table.put("P", 7);
		table.put("R", 7);
		table.put("S", 7);

		table.put("T", 8);
		table.put("U", 8);
		table.put("V", 8);

		table.put("W", 9);
		table.put("X", 9);
		table.put("Y", 9);
	}

	public static void main(String[] args) throws FileNotFoundException {
		String path = PhoneNumber.class.getResource("").getPath();
		Scanner sc = new Scanner(new File(path + "PhoneNumber.txt"));
		int n = sc.nextInt();
		String[] numbers = new String[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.next();
		}

		Map<String, Long> map = Stream.of(numbers)
				.map(i -> i.replaceAll("-", ""))
				.map(i -> MessageFormat.format("{0}{1}{2}-{3}{4}{5}{6}", Stream.of(i.split("")).map(getStringStringFunction()).toArray())).collect(STRING_MAP_COLLECTOR);
		System.out.println(map);
	}

	private static Function<String, String> getStringStringFunction() {
		return s -> {
			if (s.matches("[A-Y]")) {
				return String.valueOf(table.get(s));
			}
			return s;
		};
	}
}
