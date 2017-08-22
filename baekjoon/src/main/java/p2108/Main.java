package p2108;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}
		float avg = list.stream().collect(Collectors.averagingInt(Integer::valueOf)).floatValue();
		System.out.format("%.0f%n", avg);

		List<Integer> list1 = list.stream().sorted().collect(toList());
		System.out.println(list1.get(n / 2));

		Map<Integer, Long> map = list.stream().sorted().collect(groupingBy(Integer::valueOf, Collectors.counting()));
		Map.Entry entry = map.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		List<Integer> list2 = map.entrySet().stream().filter(e -> e.getValue().equals(entry.getValue())).map(e -> e.getKey()).sorted().collect(toList());
		if (list2.size() > 2) {
			System.out.println(list2.get(1));
		} else {
			System.out.println(entry.getKey());
		}

		System.out.println(list.stream().max(Comparator.comparing(Integer::intValue)).get() - list.stream().min(Comparator.comparing(Integer::intValue)).get());
	}
}