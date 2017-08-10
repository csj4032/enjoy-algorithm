import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DashInsert {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] numbers = sc.nextLine().split("");
		IntStream.range(0, numbers.length).reduce((a, b) -> {
			Integer c = Integer.valueOf(numbers[a]) % 2;
			Integer d = Integer.valueOf(numbers[b]) % 2;
			if (c == 0 && d == 0) numbers[a] = numbers[a] + "*";
			if (c == 1 && d == 1) numbers[a] = numbers[a] + "-";
			return b;
		});
		System.out.println(Arrays.asList(numbers).stream().reduce((a, b) -> a + b).orElse(""));
	}
}