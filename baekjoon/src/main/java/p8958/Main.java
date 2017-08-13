package p8958;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			list.add(Stream.of(sc.next().split("X")).filter(e -> !e.equals("")).map(e -> {
				return Stream.iterate(1, k -> k + 1).mapToInt(Integer::valueOf).limit(e.length()).sum();
			}).mapToInt(Integer::valueOf).sum());
		}
		list.forEach(System.out::println);
	}
}