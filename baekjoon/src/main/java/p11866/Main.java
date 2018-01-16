package p11866;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Deque<String> deque = new LinkedList();
		List<String> list = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			deque.add(String.valueOf(i));
		}

		while (!deque.isEmpty()) {
			for (int i = 1; i < m; i++) {
				deque.addLast(deque.pop());
			}
			list.add(deque.poll());
		}

		System.out.println(list.stream().collect(Collectors.joining(", ", "<", ">")));
	}
}