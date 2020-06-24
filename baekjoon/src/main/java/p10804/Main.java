package p10804;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	private static List<Integer> cards = new ArrayList<>();

	static {
		for (int i = 1; i <= 20; i++) {
			cards.add(i);
		}
	}

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			var start = sc.nextInt();
			var end = sc.nextInt();
			reverse(start, end);
		}
		System.out.println(cards.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}

	private static void reverse(int start, int end) {
		List<Integer> temp = cards.subList(start - 1, end);
		Collections.reverse(temp);
		for (int i = start - 1; i < end; i++) {
			cards.set(i, temp.get(i - (start - 1)));
		}
	}
}
