package p1302;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String book = sc.next();
			if (map.containsKey(book)) {
				map.put(book, map.get(book) + 1);
			} else {
				map.put(book, 1);
			}
		}
		List<String> list = map.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList()))).entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toList()).get(0).getValue();
		list.sort(Comparator.naturalOrder());
		System.out.println(list.get(0));
	}
}
