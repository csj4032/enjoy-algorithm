package p1475;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] n = sc.next().replaceAll("9", "6").split("");
		Map<String, Long> map = Stream.of(n).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
		if(map.get("6") != null) map.put("6", (map.get("6") / 2) + ((map.get("6") % 2 == 0) ? 0 : 1));
		Map.Entry<String, Long> entry = map.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println(entry.getValue());
	}
}