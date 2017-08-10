import java.util.*;
import java.util.stream.Collectors;

public class CreateTheLargestNumber {

	static List<Integer> numbers = new ArrayList<>();
	static int c = 0;

	public static void main(String[] args) {
		String[] strings = new Scanner(System.in).next().split(",");
		factorial(strings, strings.length, 0);
		//System.out.println(numbers.stream().max(Comparator.comparing(Integer::intValue)).get());
	}

	public static void factorial(String[] strings, int n, int d) {
		if (n == d) {
			numbers.add(Integer.valueOf(Arrays.asList(strings).stream().collect(Collectors.joining())));
			return;
		}

		for (int i = d; i < n; i++) {
			System.out.println("factorial " + d + " for " + i);
			swap(strings, i, d);
			factorial(strings, n, d + 1);
			swap(strings, i, d);
		}
	}

	public static void swap(String[] strings, int i, int d) {
		String temp = strings[i];
		strings[i] = strings[d];
		strings[d] = temp;
	}
}