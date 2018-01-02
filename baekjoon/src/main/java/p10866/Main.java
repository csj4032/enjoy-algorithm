package p10866;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String command = sc.next();
			if (command.equals("push_front")) {
				int x = sc.nextInt();
				deque.push(x);
			}
			if (command.equals("push_back")) {
				int x = sc.nextInt();
				deque.addLast(x);
			}
			if (command.equals("pop_front")) {
				System.out.println(deque.isEmpty() ? -1 : deque.pop());
			}
			if (command.equals("pop_back")) {
				System.out.println(deque.isEmpty() ? -1 : deque.pollLast());
			}
			if (command.equals("size")) {
				System.out.println(deque.size());
			}
			if (command.equals("empty")) {
				System.out.println(deque.isEmpty() ? 1 : 0);
			}
			if (command.equals("front")) {
				System.out.println(deque.isEmpty() ? -1 : deque.getFirst());
			}
			if (command.equals("back")) {
				System.out.println(deque.isEmpty() ? -1 : deque.getLast());
			}
		}
	}
}