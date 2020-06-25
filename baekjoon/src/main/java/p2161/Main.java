package p2161;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var queue = new LinkedList<Integer>();
		for (Integer i = 1; i <= n; i++) {
			queue.addLast(i);
		}

		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			sb.append(queue.peek() + " ");
			queue.pop();
			queue.addLast(queue.peek());
			queue.pop();
		}
		System.out.println(sb.toString());
	}
}