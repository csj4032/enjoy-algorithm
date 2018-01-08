package p1158;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Deque<Integer> deque = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			deque.add(i + 1);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m-1; j++) {
				deque.addLast(deque.poll());
			}
			list.add(deque.poll());
		}

		System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(", ","<", ">")).toString());
	}
}