package p10102;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		Map<String, Long> map = Arrays.stream(s.split("")).collect(groupingBy(String::valueOf, counting()));
		if (map.getOrDefault("A", 0L) > map.getOrDefault("B", 0L)) {
			System.out.println("A");
		} else if (map.getOrDefault("A", 0L) < map.getOrDefault("B", 0L)) {
			System.out.println("B");
		} else {
			System.out.println("Tie");
		}
	}
}
