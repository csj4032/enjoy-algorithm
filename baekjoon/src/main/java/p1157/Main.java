package p1157;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map.Entry<Long, List<String>> firstEntry = Stream.of(sc.next().toUpperCase().split("")).collect(groupingBy(String::valueOf, counting()))
				.entrySet().stream().collect(groupingBy(Map.Entry::getValue, mapping(Map.Entry::getKey, toList())))
				.entrySet().stream().collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, TreeMap::new)).descendingMap().firstEntry();
		System.out.println(firstEntry.getValue().size() > 1 ? "?" : firstEntry.getValue().get(0));
	}
}