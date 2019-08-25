package p3986;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = 0;
		for (int i = 0; i < n; i++) {
			m += isGood(sc.next()) ? 1 : 0;
		}
		System.out.println(m);
	}

	private static boolean isGood(String ab) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < ab.length(); i++) {
			if (!stack.isEmpty() && ab.charAt(i) == stack.peek()) {
				stack.pop();
			} else {
				stack.push(ab.charAt(i));
			}
		}
		return stack.isEmpty();
	}
}