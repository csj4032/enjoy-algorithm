package p2577;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Long> map = Stream.of(String.valueOf(sc.nextInt() * sc.nextInt() * sc.nextInt()).split("")).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		Stream.iterate(0, n -> n + 1).limit(10).forEach(n -> {
			System.out.println(map.get(String.valueOf(n)) == null ? 0 : map.get(String.valueOf(n)));
		});
	}
}