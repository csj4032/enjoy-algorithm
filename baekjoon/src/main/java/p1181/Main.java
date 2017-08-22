package p1181;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> words = new ArrayList();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			words.add(sc.next());
		}
		Map<Integer, List<String>> map = words.stream().distinct().collect(Collectors.groupingBy(String::length));
		map.keySet().stream().sorted().forEach(e-> map.get(e).stream().sorted().forEach(k-> System.out.println(k)));
	}
}